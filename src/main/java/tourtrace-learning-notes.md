# TourTrace 项目学习笔记

> 基于 LLM Agent 的旅游订单问题排障系统调研记录
> 整理时间：2026-05-08

---

## 一、项目是做什么的（STAR 之 S + T）

### Situation（背景）
- 旅游订单业务线在出现"退款失败、支付异常、签证进度查询"等问题时，客服/运营需要跨多个系统（订单库、支付、签证、邮轮、火车票等）手工查询，排障效率低、知识沉淀难共享。

### Task（目标）
- 做一个"**订单问题排障助手**"：用户在飞书里 @ 机器人问"XX 订单为什么退款失败？"，系统自动调度 LLM Agent 去各业务系统拉数据、做归因，把结论流式推回飞书卡片，同时沉淀历史经验供下次复用。

### Action（方案总览）
技术栈：
- **Web 框架**：FastAPI + Uvicorn
- **Agent 编排**：LangGraph 1.0.8 + DeepAgents + LangChain
- **知识检索**：ChromaDB（向量库）+ 飞书多维表格（权威源）
- **状态持久化**：CRedis（对话状态）+ 飞书多维表格（长期经验）
- **消息通道**：飞书 WebSocket 长连接
- **工具协议**：FastMCP 3.2.4（Model Context Protocol）
- **可观测**：OpenTelemetry（分布式追踪）
- **部署环境**：公司 PaaS，多 worker 进程

---

## 二、整体架构与目录分层（A）

```
tourtrace/
├── app.py              FastAPI 入口，装配生命周期（飞书 Bot、MCP、审计）
├── core/               核心：配置加载、异常、OTel 初始化
├── api/                HTTP 路由层（system、config、database、agent）
│
├── lark/               飞书集成：WebSocket Bot、消息处理、流式卡片
├── mcp_server/         对外暴露工具的 MCP Server
├── a2a_server/         Agent 间互调服务
│
├── dialogmanager/      对话规则（reset / /mem 指令旁路）
├── agents/             Agent 工厂、BaseAgent、subagent 递归装配
├── skills/             技能包（tour-agent、tour-group、visa 等场景）
├── tools/              工具库（cruise、settlement、train、connect…）
├── services/           业务服务（memory_manager_service 等）
│
├── infrastructure/
│   ├── config/         QConfig / KMS / memory_config
│   ├── llm/            模型解析与调用
│   ├── memory/         长期记忆存储（MemoryStore、LongTermMemory）
│   ├── repository/     SQLAlchemy DAL
│   ├── vectorstore/    ChromaDB 封装
│   └── client/         飞书、QMQ、CREDIS 客户端
│
├── checkpointer/       自定义 Redis Checkpointer（LangGraph 对话续接）
├── gateway/            代理与网关
├── schemas/            Pydantic 模型
├── utils/              日志、审计、追踪、QMQ 消费者
└── job/                后台定时任务
```

---

## 三、一次飞书对话的完整调用链（A）

```
[飞书 WebSocket 推送]
   ↓
do_p2_im_message_receive_v1()                [lark/message_handler.py:1151]
   ↓ 解析消息 / Redis 去重 / IAM 鉴权
execute_reset() / execute_mem_inject()       [dialogmanager/instruct_control/]
   ↓ 非旁路指令才继续
create_agent_by_name()                       [agents/factory.py:311]
   ↓ 递归展开 subagents + MCP 工具
_create_deep_agent(skills, tools, prompt)    [agents/base.py:111]
   ↓
agent.stream()                               [LangGraph]
   ├─ search_experience() → ChromaDB         [vectorstore/vector_source.py]
   ├─ tool_call → Repository / Client
   └─ LLM 生成
   ↓ 每个事件
update_streaming_content() → 飞书卡片         [lark/message_handler.py:376]
   ↓ 完成
close_streaming_mode() + 反馈按钮
   ↓
emit_agent_audit_record() → QMQ              [message_handler.py:941]
```

### 关键设计点

#### 1. 飞书消息分发 = WebSocket + 飞书侧路由
- **不是 HTTP webhook 被动接收**，每个 worker 启动时各自连一条飞书 WebSocket
- 飞书服务端决定把消息推给哪个 worker，**业务无法控制也不应该依赖**
- 同一个用户的多轮对话可能被不同 worker 处理 → 必须跨 worker 共享状态

#### 2. `thread_id` 作为跨 worker 会话标识
- `agents/base.py:223`：`thread_id = f"{app_id}_{chat_id}_{sender_id}"`
- 三要素固定 → 任何 worker 算出来都一样 → 自然能在 Redis 拿到同一份数据
- 同时区分"同用户在群聊 vs 私聊"的上下文隔离

#### 3. `/mem` 旁路指令（dialogmanager）
- 两轮交互：发 `/mem` → 返回模板 → 按 JSON 格式贴内容 → 保存
- 保存写两处：飞书多维表格（权威源）+ ChromaDB（检索索引）
- 最后调 `reload_experience()` 并 bump Redis 版本号通知其他 worker 同步

---

## 四、关键机制深入（A）

### 1. Checkpointer：LangGraph 对话状态持久化

**接口契约**（继承 `BaseCheckpointSaver`）：
- `put` / `put_writes` / `get_tuple` 是核心三件套
- 每个 super-step 结束后由 LangGraph 自动调用（不是每个节点）
- 父类用 `raise NotImplementedError` 定义契约，不是 `@abstractmethod`，因此允许子类选择性实现

**Redis Key 设计**（Git 式指针结构）：
```
checkpoint:{thread_id}:latest                       → 指向最新 checkpoint_id
checkpoint:{thread_id}:{checkpoint_id}              → pickle 后的完整状态
checkpoint:{thread_id}:{checkpoint_id}:writes:{tid} → 工具写入（容错）
```

**存的不是消息，是 LangGraph 完整状态快照**：
- `messages` 通道、`files` 通道、`todos` 通道、`channel_versions`…
- 必须用 `pickle` 序列化（JSON 吃不下 LangChain 对象）

**TTL 机制**：
- 默认 86400s（1 天）
- 每次 `put` 续期 → 活跃会话永不过期，不活跃自动清理

### 2. ChromaDB：进程内向量缓存

**关键事实**：代码用 `chromadb.EphemeralClient()`，是**进程内内存数据库**，多 worker 各持一份。

**多 worker 一致性方案**：
```
飞书多维表格（权威源） ── 所有 worker 都从这里加载
        ↓ bump version
     Redis（版本号）
        ↓ 每次查询 check 版本
  各 worker 独立 Chroma
```

`search_experience()` 之前会先 `_check_reload_version()`，发现版本落后就触发本 worker 的 `init_experience()` 重建。

### 3. 为什么多 worker 必然进程独立
- Python GIL → 同一进程内字节码不能真正并行
- 多核利用 → 只能多进程
- 进程隔离 → 内存缓存天然不共享
- → 所有跨 worker 状态必须外置（Redis / 飞书 / DB）

### 4. Skill 靶向加载（而非全量）
- `get_required_skills_for_agent()` 递归从主 Agent + subagents 收集所需 skill 路径
- 仅加载本次链路需要的 skill，避免 prompt 膨胀

---

## 五、向量数据库作为"记忆"的使用机制

这是项目最精巧的设计之一——向量库不是简单的"存东西查东西"，而是**经验自学习闭环**的核心。

### 1. 三层存储分工

| 存储 | 角色 | 作用 |
|------|------|------|
| 飞书"长期记忆表" | 权威经验库（SoT） | 沉淀下来的稳定经验，供 RAG 注入 |
| 飞书"临时记忆表" | 原始对话日志池 | 每次对话的路由信息，供 LLM 后续提炼 |
| ChromaDB | 向量索引缓存 | 缓存长期记忆表，提供语义检索 |

类比人类记忆：
- **长期记忆**（知识沉淀）= 长期表 + Chroma
- **短期记忆**（当前对话）= Checkpointer (Redis)
- **原始感知**（未提炼素材）= 临时表
- **遗忘机制** = 频率淘汰 + TTL
- **巩固过程** = 定时 JOB 把短期经历提炼成长期知识

### 2. 四个使用场景

#### 场景 A：读取记忆（RAG 注入）
- **入口**：`lark/message_handler.py:697`
- **流程**：用户问题 → `search_experience(query, top_k=1)` → 命中则包装成 `SystemMessage` 插入 prompt → LLM 看到"类似问题历史上这么处理的"
- **副作用**：命中时 `increment_experience_frequent()` → 飞书表 + Chroma metadata 双写，使用频率 +1
- **阈值**：相似度 ≥ 0.85 才算命中
- **归一化**：`_normalize_query()` 把订单号（连续 4 位以上数字）替换成 XXX，避免订单号干扰语义匹配

#### 场景 B：写临时记忆（记录原始路由日志）
- **入口**：`lark/message_handler.py:860`
- **只写飞书临时表，不写 Chroma** —— 原始日志嘈杂，要先提炼才有资格当经验
- 记录内容：用户问题 + 本次对话调用的 subagent/tools 路由信息

#### 场景 C：人工注入（`/mem` 指令）
- 两轮交互：发 `/mem` 拿模板 → 按 JSON 格式填内容
- **直写长期记忆表**（tag=`MANUAL`），同步 upsert Chroma，立即生效
- 绕过 LLM 提炼，因为是人工保证的权威经验

#### 场景 D：定时 JOB 提炼（自学习闭环核心）
- **入口**：`services/memory_manager_service.py:421 judge_and_compact_experience()`
- **流程**：
  ```
  读飞书临时表全部日志
    ↓ 对每条：
    ├─ Chroma 查相似长期经验（阈值 0.85）
    ├─ 命中 tag=MANUAL          → 跳过（不动人工维护的）
    ├─ 命中 tag=AUTO + 今天更新  → 跳过（避免重复刷新）
    ├─ 命中 tag=AUTO + 老的      → 可替换
    └─ 没命中                     → 新增
    ↓ 调 LLM 裁判 rectify_temp_memory() 生成经验描述
    ↓ 写长期记忆表(tag=AUTO) + 同步 Chroma
    ↓ 攒 5 条删一批临时表记录
    ↓ 淘汰：长期表 > 40 条时按 frequent 升序删
    ↓ 全量 reload Chroma + bump Redis 版本号
  ```

### 3. Tag 体系：区分经验来源与淘汰优先级

| tag | 来源 | 能否被自动替换 | 淘汰优先级 |
|-----|------|---------------|-----------|
| `MANUAL` | 人工 `/mem` | ❌ | 低（同频率下后淘汰） |
| `AUTO` | JOB 提炼 | ✅ 可被新 AUTO 替换 | 高（先淘汰） |

**淘汰规则**（`_evict_long_term_memory`）：
```python
records.sort(key=lambda r: (r.frequent, tag_order.get(r.tag, 0)))
# 主排：frequent 升序（冷门先淘汰）
# 副排：AUTO=0 优先于 MANUAL=1（同冷门时先淘汰自动的）
```
上限 40 条，超了就删。保证：向量库不膨胀、人工经验不被覆盖、热门经验留下。

### 4. 白名单控制
- `use_experience_biz` → 控制哪些业务走 RAG 注入
- `save_experience_blog` → 控制哪些业务记临时日志
- 新业务可以先只记不注入，观察一阵再启用 RAG

### 5. 数据流总图

```
[用户问] ──→ search_experience() ──→ Chroma ──→ 命中注入 prompt
                                        ↑
                                        │ reload（bump version）
                                        │
   [Agent 执行] ──→ save_temp_memory() ──→ 飞书临时表
                                             │
                                             │ 定时 JOB
                                             ↓
                                        LLM 裁判提炼
                                             ↓
                                      飞书长期记忆表  ←── /mem 人工注入
                                             │          (tag=MANUAL)
                                             │ upsert
                                             ↓
                                           Chroma
```

### 6. 设计精巧之处
1. **临时表 + 长期表两级分离** → raw data 和 distilled knowledge 之间隔着 LLM 裁判
2. **频率统计驱动淘汰** → 每次命中原地更新 Chroma metadata，不重算向量
3. **订单号归一化** → 让"XX订单支付失败"可以匹配任意订单的类似案例
4. **白名单逐步启用** → 新业务可以先观察再放量
5. **version 版本号协调多 worker** → 沿用前面的 Redis 版本号机制

---

## 六、待优化项（问题沉淀）

### 问题 1：RedisCheckpointer 大 key 风险
**现象分析**
- `put` 每次写**完整快照**而非增量
- 典型 10 轮排障对话 + 每轮 2~3 次 tool_call，pickle 后 **50KB~2MB，极端情况 5MB+**
- 且每轮生成新 `checkpoint_id` 而**不删旧的**，同一 thread 下累积多份历史快照
- 带宽放大：最后一轮 put 可能独占几 MB 写入流量

**建议方向**
- 截断 messages 历史（早期摘要化）
- 只保留 latest + 最近 N 个 checkpoint_id，超过删除
- pickle 后加 gzip 压缩（省 30~70%）
- 加大 key 监控，>1MB 告警

### 问题 2：Checkpointer 的 async 方法是同步包装
**现象分析**
- `aput` / `aget_tuple` / `aput_writes` 直接调同步方法
- 在 async 协程里执行阻塞 Redis IO → Redis 抖动时 event loop 被阻塞 → 并发请求被拖累
- 根因：CRedis 客户端没有 async 接口

**建议方向**
- 用 `await asyncio.to_thread(self.put, ...)` 把阻塞调用扔线程池
- 或引入真正的 async Redis 客户端（aioredis / redis-py asyncio 模式）

### 问题 3：`delete_thread` 用 `KEYS pattern`
**现象分析**
- `redis_checkpointer.py:333` 用 `client.keys("checkpoint:{tid}:*")`
- 代码里自己注释了"生产环境大数据量时可能有性能问题"
- Redis `KEYS` 命令是 O(N) 遍历，会阻塞单个分片
- 活跃 thread 对话一久，key 数量可达数十上百

**建议方向**
- 维护 `SET checkpoint:index:{tid}` 记录该 thread 下所有 checkpoint_id
- 删除时 `SMEMBERS` 取出精确删除，避免 `KEYS`
- 或用 `SCAN` 替代 `KEYS`（非阻塞迭代）

### 问题 4：ChromaDB 多 worker 一致性依赖"版本号反向 reload"
**现象分析**
- 每个 worker 独立持有 Chroma，同步靠 Redis 版本号通知
- 注入一条经验 → 本 worker 增量 upsert + 全量 reload → 其他 worker 下次查询才 reload
- 每次 reload 要**从飞书拉全量**重建 → 经验条数增长后耗时上升
- 飞书 API 有限流风险

**建议方向**
- 迁移到 Chroma Server 模式或用 Qdrant/Milvus（真正的共享向量库）
- 或改用持久化 Chroma + 文件锁（同机多 worker 场景）
- 当前规模（几千条）影响可控，但长期要评估

### 问题 5：pickle 序列化的脆弱性
**现象分析**
- Checkpointer 用 pickle 存状态
- LangGraph / LangChain 升级后，旧 pickle 可能反序列化失败
- 报错不直观，线上难定位

**建议方向**
- 升级前清空 Redis checkpoint（反正 TTL 才 1 天）
- 或加版本标记：`{"version": "v1", "data": pickle(...)}`，不匹配时跳过

### 问题 6：本地 macOS 开发依赖 `pysqlite3-binary`
**现象分析**
- PyPI 上 `pysqlite3-binary` 只有 Linux wheel，macOS 装不上
- Python 3.13 连 Linux wheel 都没有（本项目用的是 3.12）
- 代码层已有 `try/except ImportError` 兜底，运行没问题，但 `pip install` 会硬失败

**已处理**
- 已在 `requirements.txt` 和 `pyproject.toml` 加平台标记：
  - `pysqlite3-binary>=0.5.4; sys_platform == "linux"`
  - Linux 部署照常安装，macOS 开发自动跳过

### 问题 7：RAG 相似度阈值 0.85 是固定的
**现象分析**
- 所有业务场景共用一个阈值
- 不同领域问题密度、用词习惯不同（签证的问题和邮轮的问题相似度分布不一样）
- 固定阈值可能导致某些领域过度召回、另一些领域漏召回

**建议方向**
- 按 `domain` 配置差异化阈值（存 QConfig）
- 或基于历史命中情况自适应调节

### 问题 8：RAG 只取 top_k=1
**现象分析**
- `message_handler.py:697` 固定 `search_experience(raw_user_message, 1)`
- 如果前 3 条都高于阈值，丢弃后两条就损失了信息
- 单条经验可能片面，多条组合注入能给 LLM 更完整的上下文

**建议方向**
- 改为 top_k=3，拼接多条经验注入（按相似度倒序）
- 或根据分数梯度自动决定取几条（分数断崖时截断）

### 问题 9：`frequent` 只升不降，缺乏衰减
**现象分析**
- 每次命中 frequent+1，但从不减少
- 经验一旦曾经热门，即使业务变化后不再适用，仍长期霸占向量库
- 会阻塞新经验入库（挤占 40 条上限）

**建议方向**
- 加"指数衰减"：定期（如每周）给所有 AUTO 经验 frequent 打 0.9 折
- 或记录"最后命中时间"，淘汰时综合考虑热度和时效

### 问题 10：`reload_experience` 是全量重建
**现象分析**
- 每次任意写入后都 `init_from_bitable()` → 从飞书分页拉全部 → 清空 Chroma → 重建
- 几千条规模下还能接受，上万条后耗时显著、飞书 API 限流风险加剧
- 每个 worker 都独立 reload，成本 × N

**建议方向**
- 改增量同步：只拉"最近更新"的记录（飞书表加 update_time 字段 + view 过滤）
- 或引入中间层（如 binlog 机制）只同步变更事件

### 问题 11：LLM 裁判没有置信度门槛
**现象分析**
- `rectify_temp_memory()` 返回什么质量的经验都会入库（只要非空）
- LLM 可能从垃圾对话提炼出垃圾经验 → 污染长期记忆
- 下次命中低质经验 → 误导新对话 → 形成恶性循环

**建议方向**
- 裁判同时输出 `confidence` 分数，< 0.7 不入库
- 或做"同行评审"：用不同模型二次裁判，分数一致才入库

### 问题 12：没有"经验冲突"检测
**现象分析**
- 两条相似问题但结论不同的经验可能共存于长期表
- RAG 每次只取最相似一条，可能在不同场景命中不同结论，给出矛盾建议
- 尤其当业务逻辑变更，新老经验并存时

**建议方向**
- 新增经验前检测是否与已有经验"表述相似但 experience 不同" → 告警人工介入
- 或定期跑一致性检查 JOB，标记可疑冲突条目

---

## 七、总结

项目用"**LLM Agent + MCP + 飞书卡片 + 向量记忆**"这套组合解决了一个典型的"多系统排障、客服提效"场景。架构上四个层面值得学：

1. **无状态 worker + 外部状态存储**：GIL 决定了多进程，架构被迫把状态（对话、经验、审计）全外置，换来了横向扩容的简单
2. **权威源 + 索引缓存分离**：飞书表格做权威源（人机协同可编辑），Chroma 做检索加速层，通过 Redis 版本号协调
3. **框架契约实现**：Checkpointer 继承 LangGraph `BaseCheckpointSaver`，典型"实现接口契约"的扩展方式
4. **经验自学习闭环**：临时表 + LLM 裁判 + 长期表 + 频率淘汰，让向量库从"存储工具"升级为"持续学习的记忆系统"

待优化项集中在**性能与健壮性**（大 key、async 阻塞、KEYS 命令）、**一致性机制**（Chroma 多 worker 同步代价）、**记忆质量**（阈值固化、无衰减、无冲突检测）三个方向，当前规模都可控，但随规模增长要提前规划。
package com.exercise.algorithm.top150.list;

import com.exercise.algorithm.base.list.DLinkedNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 *
 * @author mihone
 * @since 2024/12/15 16:38
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }

    Map<Integer, DLinkedNode> map = new HashMap<>();
    int size;
    int capacity;
    DLinkedNode head = new DLinkedNode(-1, -1);
    DLinkedNode tail = new DLinkedNode(-1, -1);


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DLinkedNode dLinkedNode = map.get(key);
        if (dLinkedNode == null) {
            return -1;
        }
        remove(dLinkedNode);
        add2Head(dLinkedNode);
        return dLinkedNode.value;

    }

    private void remove(DLinkedNode dLinkedNode) {
        dLinkedNode.prev.next = dLinkedNode.next;
        dLinkedNode.next.prev = dLinkedNode.prev;
    }

    private void add2Head(DLinkedNode dLinkedNode) {
        dLinkedNode.next = head.next;
        head.next.prev = dLinkedNode;
        head.next = dLinkedNode;
        dLinkedNode.prev = head;
    }

    public void put(int key, int value) {
        DLinkedNode dLinkedNode = map.get(key);
        if (dLinkedNode != null) {
            dLinkedNode.value = value;
            remove(dLinkedNode);
            add2Head(dLinkedNode);
        } else {
            dLinkedNode = new DLinkedNode(key, value);
            map.put(key, dLinkedNode);
            size++;
            add2Head(dLinkedNode);
            if (size > capacity) {
                DLinkedNode prev = tail.prev;
                remove(prev);
                map.remove(prev.key);

            }
        }

    }
}

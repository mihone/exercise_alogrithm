package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [REPEAT]
 *
 * 主要是思路
 * LCR 055. 二叉搜索树迭代器
 *
 * @author mihone
 * @since 2025/5/18 18:21
 */
public class LCR055 {


    /**
     *
     * 时间复杂度：显然，初始化和调用 hasNext() 都只需要 O(1) 的时间。
     * 每次调用 next() 函数最坏情况下需要 O(n) 的时间；但考虑到 n 次调用 next() 函数总共会遍历全部的 n 个节点，
     * 因此总的时间复杂度为 O(n)，因此单次调用平均下来的均摊复杂度为 O(1)。
     *
     * 空间复杂度：O(n)，其中 n 是二叉树的节点数量。空间复杂度取决于栈深度，
     * 而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。
     *
     *
     *
     *
     * */

    static class BSTIterator {

        private TreeNode cur;
        private Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new LinkedList<TreeNode>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int ret = cur.val;
            cur = cur.right;
            return ret;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }

    }
}

package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [REPEAT]
 * LCR 043. 完全二叉树插入器
*  @author mihone
*  @since 2025/5/18 14:25
*/
public class LCR043 {
    public static void main(String[] args) {

    }

    static class CBTInserter {

        //先按照层序遍历找到不完全的节点，然后按照队列顺序，insert的时候将 insert后变成完全节点的元素出队，将新增的元素
        //插入队尾。
        LinkedList<TreeNode> candidate;
        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.candidate = new LinkedList<TreeNode>();
            this.root = root;

            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (!(node.left != null && node.right != null)) {
                    candidate.offer(node);
                }
            }
        }

        public int insert(int val) {
            TreeNode child = new TreeNode(val);
            if (candidate.isEmpty()) {
                candidate.offer(child);
                return 0;
            }
            TreeNode node = candidate.peek();
            int ret = node.val;
            if (node.left == null) {
                node.left = child;
            } else {
                node.right = child;
                candidate.poll();
            }
            candidate.offer(child);
            return ret;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}

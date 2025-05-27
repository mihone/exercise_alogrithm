package com.exercise.algorithm.hot100.v1.tree;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
*  @author mihone
*  @since 2025/2/4 19:59
*/
public class LevelOrder {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> part = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll!=null) {
                    part.add(poll.val);
                    if (poll.left!=null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right!=null) {
                        queue.offer(poll.right);
                    }
                }
            }
            ret.add(part);
        }
        return ret;
    }

}

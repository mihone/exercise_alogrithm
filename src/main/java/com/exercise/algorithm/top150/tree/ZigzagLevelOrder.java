package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
*  @author mihone
*  @since 2025/1/4 12:57
*/
public class ZigzagLevelOrder {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        boolean reverse = false;
        while (!queue.isEmpty()){

            int temp = 0;
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                level.add(poll.val);
                if (poll.left!=null) {
                    queue.offer(poll.left);
                    temp++;
                }
                if (poll.right!=null) {
                    queue.offer(poll.right);
                    temp++;
                }
            }
            levelSize = temp;
            if (reverse) {
                Collections.reverse(level);
            }
            ret.add(level);
            reverse = !reverse;

        }
        return ret;
    }
}

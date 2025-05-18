package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LCR 046. 二叉树的右视图
*  @author mihone
*  @since 2025/5/18 15:40
*/
public class LCR046 {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int count = 0 ;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    count++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    count++;
                }
                if (i == size-1) {
                    ret.add(poll.val);
                }
            }
            size = count;

        }
        return ret;
    }
}

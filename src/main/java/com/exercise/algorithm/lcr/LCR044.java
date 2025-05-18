package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LCR 044. 在每个树行中找最大值
*  @author mihone
*  @since 2025/5/18 15:33
*/
public class LCR044 {
    public static void main(String[] args) {

    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int count = 0 ;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                max = Math.max(max, poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                    count++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    count++;
                }
            }
            ret.add(max);
            size = count;

        }
        return ret;

    }
}

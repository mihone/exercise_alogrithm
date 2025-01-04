package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
*  @author mihone
*  @since 2025/1/4 12:48
*/
public class AverageOfLevels {


    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Double> ret = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        while (!queue.isEmpty()){
            int temp = 0;
            long sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                sum += poll.val;
                if (poll.left!=null) {
                    queue.offer(poll.left);
                    temp++;
                }
                if (poll.right!=null) {
                    queue.offer(poll.right);
                    temp++;
                }
            }
            ret.add((double)sum/(double) levelSize);
            levelSize = temp;

        }
        return ret;

    }
}

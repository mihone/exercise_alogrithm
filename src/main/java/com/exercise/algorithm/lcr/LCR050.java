package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * LCR 050. 路径总和 III
 *
 * @author mihone
 * @since 2025/5/18 17:21
 */
public class LCR050 {

    public static void main(String[] args) {

    }

    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return count;
        }
        pathSumInternal(root, targetSum);
        return count;
    }

    public int pathSumInternal(TreeNode root, long targetSum) {
        if (root == null) {
            return count;
        }
        cal(root, targetSum);
        pathSumInternal(root.left, targetSum);
        pathSumInternal(root.right, targetSum);
        return count;
    }

    public void cal(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        if (root.val == targetSum) {
            count++;
        }
        cal(root.left, targetSum - root.val);
        cal(root.right, targetSum - root.val);
    }
}

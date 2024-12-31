package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.TreeNode;

/**
 * 112. 路径总和
 * @author mihone
 * @since 2024/12/30 21:44
 */
public class HasPathSum {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }

        boolean l = hasPathSum(root.left, targetSum - root.val);
        boolean r = hasPathSum(root.right, targetSum - root.val);
        return l || r;

    }
}

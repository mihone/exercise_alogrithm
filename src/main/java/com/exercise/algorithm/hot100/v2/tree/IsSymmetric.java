package com.exercise.algorithm.hot100.v2.tree;

import com.exercise.algorithm.base.tree.TreeNode;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSymmetric(root.left, root.right);

    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null) {
            return false;
        }
        if (right == null) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left) && left.val == right.val;
    }
}

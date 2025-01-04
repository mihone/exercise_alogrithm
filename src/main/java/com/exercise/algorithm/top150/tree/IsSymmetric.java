package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.TreeNode;

/**
 *
 * 101. 对称二叉树
*  @author mihone
*  @since 2024/12/22 19:51
*/
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);

    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }



}

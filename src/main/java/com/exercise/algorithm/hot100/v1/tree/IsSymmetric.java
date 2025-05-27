package com.exercise.algorithm.hot100.v1.tree;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * 101. 对称二叉树
*  @author mihone
*  @since 2025/2/4 19:43
*/
public class IsSymmetric {

    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);

    }
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left== null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean symmetric = isSymmetric(left.left, right.right);
        return symmetric && isSymmetric(left.right, right.left);
    }
}

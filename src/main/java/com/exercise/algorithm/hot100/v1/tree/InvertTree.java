package com.exercise.algorithm.hot100.v1.tree;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * 226. 翻转二叉树
*  @author mihone
*  @since 2025/2/4 19:41
*/
public class InvertTree {
    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;

    }
}

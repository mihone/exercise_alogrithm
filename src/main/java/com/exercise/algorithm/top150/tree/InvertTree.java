package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * 226. 翻转二叉树
*  @author mihone
*  @since 2024/12/22 19:49
*/
public class InvertTree {

    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;

    }
}

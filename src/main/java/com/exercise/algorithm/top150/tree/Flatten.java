package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * 114. 二叉树展开为链表
 *
 * @author mihone
 * @since 2024/12/29 11:49
 */
public class Flatten {

    public static void main(String[] args) {

    }
    // 1
    //  2
    // 3

    public void flatten(TreeNode root) {

        while (root != null) {
            TreeNode node = root.left;
            if (node != null) {
                while (node.right != null) {
                    node = node.right;
                }
                node.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }

    }
}

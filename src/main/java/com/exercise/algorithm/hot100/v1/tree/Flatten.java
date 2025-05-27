package com.exercise.algorithm.hot100.v1.tree;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * 114. 二叉树展开为链表
 *
 * @author mihone
 * @since 2025/2/9 11:33
 */
public class Flatten {

    public static void main(String[] args) {

    }

    //先序遍历
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode c = cur.left;
                while (c.right != null) {
                    c = c.right;
                }
                c.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }

    }
}

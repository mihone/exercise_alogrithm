package com.exercise.algorithm.hot100.tree;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * 104. 二叉树的最大深度
*  @author mihone
*  @since 2025/2/4 19:39
*/
public class MaxDepth {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = maxDepth(root.left);
        int i2 = maxDepth(root.right);
        return Math.max(i, i2)+1;

    }
}

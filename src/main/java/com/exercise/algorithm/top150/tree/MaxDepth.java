package com.exercise.algorithm.top150.tree;


import com.exercise.algorithm.base.TreeNode;

/**
 * 104. 二叉树的最大深度
*  @author mihone
*  @since 2024/12/20 22:34
*/
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;

    }
}

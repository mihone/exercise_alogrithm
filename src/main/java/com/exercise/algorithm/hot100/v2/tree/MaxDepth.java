package com.exercise.algorithm.hot100.v2.tree;

import com.exercise.algorithm.base.tree.TreeNode;

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

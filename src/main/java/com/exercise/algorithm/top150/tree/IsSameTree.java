package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.TreeNode;

/**
 * 100. 相同的树
 *
 * @author mihone
 * @since 2024/12/22 19:28
 */
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        boolean sameTree = isSameTree(p.left, q.left);
        sameTree &= isSameTree(p.right, q.right);
        return p.val == q.val && sameTree;

    }


}

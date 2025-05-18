package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * [ENHANCE]
 * LCR 047. 二叉树剪枝
 *
 * @author mihone
 * @since 2025/5/18 15:43
 */
public class LCR047 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        boolean del = del(root);

        return del && root.val == 0 ? null : root;

    }

    public boolean del(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean del = del(root.left);
        if (del) {
            root.left = null;
        }
        boolean del2 = del(root.right);
        if (del2) {
            root.right = null;
        }
        return del && del2 && root.val == 0;

    }
}

package com.exercise.algorithm.hot100.tree;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * 98. 验证二叉搜索树
*  @author mihone
*  @since 2025/2/4 20:13
*/
public class IsValidBST {
    public static void main(String[] args) {

    }

    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root==null) {
            return true;
        }
        boolean validBST = isValidBST(root.left);
        if (!validBST) {
            return false;
        }
        if (pre!=null) {
            if (pre.val>=root.val) {
                return false;
            }
        }
        pre = root;

       return isValidBST(root.right);
    }
}

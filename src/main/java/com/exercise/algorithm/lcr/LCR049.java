package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * LCR 049. 求根节点到叶节点数字之和
*  @author mihone
*  @since 2025/5/18 17:12
*/
public class LCR049 {


    public int sumNumbers(TreeNode root) {

        int sum = sum(root, 0);
        return sum;

    }

    public int sum(TreeNode root,int pre) {
        int sum = 0;
        int i = pre * 10 + root.val;
        if (root.left == null && root.right == null) {
            return i;
        }
        if (root.left!=null) {
            int left = sum(root.left, i);
            sum += left;
        }
        if (root.right!=null) {
            int right = sum(root.right, i);
            sum += right;
        }
        return sum;

    }
}

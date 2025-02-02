package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * [ENHANCE]
 * 129. 求根节点到叶节点数字之和
 *
 * @author mihone
 * @since 2024/12/30 21:57
 */
public class SumNumbers {

    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }


}

package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
*  @author mihone
*  @since 2025/1/8 21:59
*/
public class GetMinimumDifference {
    public static void main(String[] args) {

    }
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}

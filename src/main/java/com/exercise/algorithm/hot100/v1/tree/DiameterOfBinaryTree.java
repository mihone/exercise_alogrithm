package com.exercise.algorithm.hot100.v1.tree;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * [REPEAT]
 * 543. 二叉树的直径
*  @author mihone
*  @since 2025/2/4 19:50
*/
public class DiameterOfBinaryTree {
    public static void main(String[] args) {

    }

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = maxDepth(root.left);
        int i2 = maxDepth(root.right);
        //最大直径不一定经过根节点
        ans = Math.max(ans, i+i2);
        return Math.max(i, i2)+1;
    }
}

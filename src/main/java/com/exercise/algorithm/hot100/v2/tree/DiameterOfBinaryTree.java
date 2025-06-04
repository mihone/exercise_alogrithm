package com.exercise.algorithm.hot100.v2.tree;

import com.exercise.algorithm.base.tree.TreeNode;
/**
 * [ENHANCE]
*  @author mihone
*  @since 2025/6/3 20:06
*/
public class DiameterOfBinaryTree {

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        internal(root);
        //求边，需要减1
        return ans - 1;
    }



    public int internal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = internal(root.left);
        int right = internal(root.right);
        ans  = Math.max(ans, left + right + 1);
        return Math.max(left,right) + 1;
    }
}

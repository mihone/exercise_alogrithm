package com.exercise.algorithm.hot100.tree;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * 230. 二叉搜索树中第 K 小的元素
*  @author mihone
*  @since 2025/2/9 10:41
*/
public class KthSmallest {
    public static void main(String[] args) {

    }

    int ret = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return ret;
        }
        internal(root, k);
        return ret;
    }

    public void internal(TreeNode root, int k) {
        if (root == null) {
            return ;
        }
        internal(root.left, k);
        count++;

        if (count == k) {
            if (ret==0) {

            ret = root.val;
            }
            return;
        }
        internal(root.right, k);
    }

}

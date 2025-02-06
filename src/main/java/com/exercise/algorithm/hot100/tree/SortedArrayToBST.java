package com.exercise.algorithm.hot100.tree;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * @author mihone
 * @since 2025/2/4 20:10
 */
public class SortedArrayToBST {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);

    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start < 0 || start >= nums.length || end < 0 || end >= nums.length || start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;

    }
}

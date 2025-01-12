package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第 K 小的元素
 *
 * @author mihone
 * @since 2025/1/11 10:09
 */
public class KthSmallest {

    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        if (k>list.size()) {
            return 0;
        }
        return list.get(k-1);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

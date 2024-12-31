package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
*  @author mihone
*  @since 2024/12/31 20:03
*/
public class BSTIterator {

    public static void main(String[] args) {

    }

    private int idx;
    private List<Integer> arr;

    public BSTIterator(TreeNode root) {
        idx = 0;
        arr = new ArrayList<Integer>();
        inorderTraversal(root, arr);
    }

    public int next() {
        return arr.get(idx++);
    }

    public boolean hasNext() {
        return idx < arr.size();
    }

    private void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }

}

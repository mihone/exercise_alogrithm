package com.exercise.algorithm.hot100.v1.tree;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author mihone
 * @since 2025/2/9 11:41
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> pre = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            pre.put(preorder[i], i);
        }
        Map<Integer, Integer> in = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        TreeNode root = buildTree(pre, in, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    public TreeNode buildTree(Map<Integer, Integer> pre, Map<Integer, Integer> in, int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart < 0 || inStart < 0 || preEnd >= inorder.length || inEnd >= inorder.length || preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        Integer index = in.get(rootValue);
        int leftNum = index - inStart;
        TreeNode l = buildTree(pre, in, preorder, inorder, preStart + 1, preStart + leftNum, inStart, index - 1);
        TreeNode r = buildTree(pre, in, preorder, inorder, preStart + leftNum + 1, preEnd, index + 1, inEnd);
        root.left = l;
        root.right = r;
        return root;
    }

    public static void main(String[] args) {

    }
}

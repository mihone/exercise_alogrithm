package com.exercise.algorithm.hot100.v2.tree;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {


    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode treeNode = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return treeNode;

    }

//1 2 3 4 5 6
    public TreeNode buildTree( int[] preorder, int[] inorder,
                              int preStart,int preEnd,int inStart,int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        Integer rootValIndex = inMap.get(rootVal);
        TreeNode treeNode = new TreeNode(rootVal);
        int leftCount = rootValIndex - inStart;
        treeNode.left = buildTree(preorder, inorder, preStart + 1, preStart + leftCount, inStart, rootValIndex - 1);
        treeNode.right = buildTree(preorder,inorder,preStart + leftCount+1, preEnd, rootValIndex + 1, inEnd);
        return treeNode;
    }
}

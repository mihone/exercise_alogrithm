package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * @author mihone
 * @since 2024/12/28 20:52
 */
public class BuildTreePost {


    public static void main(String[] args) {

    }

    Map<Integer, Integer> postMap = new HashMap<Integer, Integer>();
    Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
    int postLength = 0;
    int inLength = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(i, postorder[i]);
        }
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        postLength = postorder.length;
        inLength = inorder.length;
        return buildTree(0, postorder.length - 1, 0, inorder.length - 1);

    }

    public TreeNode buildTree(int postStartIndex, int postEndIndex, int inStartIndex, int inEndIndex) {
        if (postStartIndex > postEndIndex) {
            return null;
        }
        if (inStartIndex > inEndIndex) {
            return null;
        }
        if (postStartIndex < 0 || inStartIndex < 0 || postEndIndex >= postLength || inEndIndex >= inLength) {
            return null;
        }

        Integer postEndNum = postMap.get(postEndIndex);

        Integer inRootIndex = inMap.get(postEndNum);
        TreeNode root = new TreeNode();
        root.val = postEndNum;
        int leftCount = inRootIndex - inStartIndex;
        int rightCount = inEndIndex - inRootIndex;


        TreeNode left = buildTree(postStartIndex, postStartIndex + leftCount-1, inStartIndex, inRootIndex - 1);
        TreeNode right = buildTree(postStartIndex + leftCount , postEndIndex - 1, inRootIndex + 1, inEndIndex);
        root.left = left;
        root.right = right;
        return root;
    }
}

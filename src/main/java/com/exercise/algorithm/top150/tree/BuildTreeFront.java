package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author mihone
 * @since 2024/12/23 22:16
 */
public class BuildTreeFront {

    public static void main(String[] args) {

    }

    Map<Integer, Integer> preMap = new HashMap<Integer, Integer>();
    Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
    int preLength = 0;
    int inLength = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            preMap.put(i, preorder[i]);
        }
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        preLength = preorder.length;
        inLength = inorder.length;
        return buildTree(0,preorder.length-1,0,inorder.length-1);

    }

    public TreeNode buildTree(int preStartIndex, int preEndIndex, int inStartIndex, int inEndIndex) {
        if (preStartIndex > preEndIndex) {
            return null;
        }
        if (inStartIndex > inEndIndex) {
            return null;
        }
        if (preStartIndex<0 || inStartIndex<0 || preEndIndex>=preLength || inEndIndex>=inLength) {
            return null;
        }

        Integer preStartNum = preMap.get(preStartIndex);

        Integer inRootIndex = inMap.get(preStartNum);
        TreeNode root = new TreeNode();
        root.val = preStartNum;
        int leftCount = inRootIndex - inStartIndex;
        int rightCount = inEndIndex - inRootIndex;


        TreeNode left = buildTree(preStartIndex + 1, preStartIndex + leftCount, inStartIndex, inRootIndex - 1);
        TreeNode right = buildTree(preStartIndex + leftCount + 1, preEndIndex, inRootIndex + 1, inEndIndex);
        root.left = left;
        root.right = right;
        return root;
    }
}

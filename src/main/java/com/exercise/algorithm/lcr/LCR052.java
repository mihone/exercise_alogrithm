package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LCR 052. 递增顺序搜索树
*  @author mihone
*  @since 2025/5/18 17:34
*/
public class LCR052 {

    public static void main(String[] args) {

    }

    List<TreeNode> list = new ArrayList<TreeNode>();
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        for (TreeNode treeNode : list) {
            treeNode.left = null;
            treeNode.right = null;
        }
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }

        return list.get(0);

    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root);
        inorder(root.right);


    }
}

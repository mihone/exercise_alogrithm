package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LCR 054. 把二叉搜索树转换为累加树
*  @author mihone
*  @since 2025/5/18 18:08
*/
public class LCR054 {

    public static void main(String[] args) {

    }

    List<TreeNode> list = new ArrayList<TreeNode>();

    public TreeNode convertBST2(TreeNode root) {
        inorder(root);
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i).val;
            list.get(i).val = sum;
        }
        return root;

    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }

    //反中序遍历
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}

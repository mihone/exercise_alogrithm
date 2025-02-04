package com.exercise.algorithm.hot100.tree;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
*  @author mihone
*  @since 2025/2/3 20:50
*/
public class InorderTraversal {

    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inorderTraversal(root,ret);
        return ret;
    }
    public void inorderTraversal(TreeNode root,List<Integer> ret) {
        if (root== null) {
            return;
        }
        inorderTraversal(root.left, ret);
        ret.add(root.val);
        inorderTraversal(root.right, ret);

    }
}

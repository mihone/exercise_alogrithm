package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * [ENHANCE]
 * LCR 053. 二叉搜索树中的中序后继
*  @author mihone
*  @since 2025/5/18 17:43
*/
public class LCR053 {


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(1);
        LCR053 lcr053 = new LCR053();
        lcr053.inorderSuccessor(treeNode, treeNode.left.left.left);


    }

    TreeNode pre = null;
    TreeNode ret = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorderSuccessorInternal(root, p);
        return pre == p ? ret : null;

    }

    public void inorderSuccessorInternal(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        inorderSuccessorInternal(root.left, p);
        if (pre == p) {
            return;
        }
        pre = ret;
        ret = root;
        inorderSuccessorInternal(root.right, p);


    }
}

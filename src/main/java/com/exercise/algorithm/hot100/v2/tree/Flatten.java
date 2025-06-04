package com.exercise.algorithm.hot100.v2.tree;

import com.exercise.algorithm.base.tree.TreeNode;

public class Flatten {

    public void flatten(TreeNode root) {

        TreeNode cur = root;
        while (cur!=null){
            if (cur.left!=null) {
                TreeNode temp = cur.left;
                while (temp.right!=null){
                    temp = temp.right;
                }
                temp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;

        }

    }
}

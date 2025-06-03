package com.exercise.algorithm.hot100.v2.tree;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> ret = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            ret.add(pop.val);
            if (pop.right != null) {
                root = pop.right;
            }
        }

        return ret;
    }


}

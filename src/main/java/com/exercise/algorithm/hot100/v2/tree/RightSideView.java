package com.exercise.algorithm.hot100.v2.tree;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {


    public List<Integer> rightSideView(TreeNode root) {
        if (root ==null) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        queue.offer(root);
        int levelSize = 1;
        while (!queue.isEmpty()) {
            List<Integer> part = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                part.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                if (i == levelSize-1) {
                    ret.add(poll.val);
                }
            }
            levelSize = queue.size();
        }
        return ret;
    }
}

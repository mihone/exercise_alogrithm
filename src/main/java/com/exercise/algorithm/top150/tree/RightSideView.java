package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
*  @author mihone
*  @since 2025/1/4 12:40
*/
public class RightSideView {
    public static void main(String[] args) {

    }
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ret = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        while (!queue.isEmpty()){

            int temp = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                if (poll.left!=null) {
                    queue.offer(poll.left);
                    temp++;
                }
                if (poll.right!=null) {
                    queue.offer(poll.right);
                    temp++;
                }
                if (i == levelSize-1) {
                    ret.add(poll.val);
                }
            }
            levelSize = temp;

        }
        return ret;

    }
}

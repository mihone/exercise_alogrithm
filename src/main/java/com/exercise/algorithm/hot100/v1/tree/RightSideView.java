package com.exercise.algorithm.hot100.v1.tree;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
*  @author mihone
*  @since 2025/2/9 11:21
*/
public class RightSideView {
    public static void main(String[] args) {

    }


    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        while (!queue.isEmpty()) {
            int count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    continue;
                }
                if (i == size-1) {
                    list.add(temp.val);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                    count++;
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    count++;
                }
            }
            size = count;
        }
        return list;

    }
}

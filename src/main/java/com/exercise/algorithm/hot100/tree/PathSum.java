package com.exercise.algorithm.hot100.tree;

import com.exercise.algorithm.base.tree.TreeNode;

/**
 * [ENHANCE]
 * 437. 路径总和 III
*  @author mihone
*  @since 2025/2/9 12:01
*/
public class PathSum {

    public static void main(String[] args) {

    }

    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return count;
        }
        order(root, targetSum);
        return count;

    }
    public void order(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        order(root.left, targetSum);
        pathSumInternal(root, targetSum );
        order(root.right, targetSum);
    }


    public void pathSumInternal(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        //入参可正可负，这里不需要return
        if (root.val == targetSum) {
            count++;
        }
        pathSumInternal(root.left, targetSum - root.val);
        pathSumInternal(root.right, targetSum - root.val);

    }
}

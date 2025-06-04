package com.exercise.algorithm.hot100.v2.tree;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * [REPEAT]
*  @author mihone
*  @since 2025/6/4 17:22
*/
public class PathSum {

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        treeNode.right.right.right = new TreeNode(4);
        treeNode.right.right.right.right = new TreeNode(5);
        System.out.println(pathSum.pathSum(treeNode, 3));
    }


//    int count = 0;
//
//    public int pathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return 0;
//        }
//
//        pathSumInternal(root, targetSum);
//        pathSum(root.left, targetSum);
//        pathSum(root.right, targetSum);
//        return count;
//
//    }
//    public void pathSumInternal(TreeNode root, int targetSum) {
//        if (root == null) {
//            return;
//        }
//        if (targetSum == root.val) {
//            count++;
//        }
//
//        pathSumInternal(root.left, targetSum - root.val);
//        pathSumInternal(root.right, targetSum - root.val);
//    }


    //前缀和
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        //刚好前缀和就是k的情况。
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

}

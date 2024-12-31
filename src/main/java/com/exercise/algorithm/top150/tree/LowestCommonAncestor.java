package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 236. 二叉树的最近公共祖先
 *
 * @author mihone
 * @since 2024/12/31 20:29
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode tmp = p;


        buildFather(map, root);
        Set<TreeNode> set = new HashSet<>();
        while (tmp != null) {
            set.add(tmp);
            tmp = map.get(tmp);
        }
        while (q != null && !set.contains(q)) {
            q = map.get(q);
        }
        return q;


    }

    public void buildFather(Map<TreeNode, TreeNode> map, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }
        buildFather(map, root.left);
        buildFather(map, root.right);
    }
}

package com.exercise.algorithm.hot100.tree;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 236. 二叉树的最近公共祖先
 *
 * @author mihone
 * @since 2025/2/9 12:15
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        order(root, map);
        Set<TreeNode> set = new HashSet<>();
        while (p!=null){
            set.add(p);
            p = map.get(p);
        }
        while (q!=null){
            if (set.contains(q)) {
                return q;
            }
            q = map.get(q);
        }
        return null;

    }

    public void order(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }
        order(root.left, map);
        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }
        order(root.right, map);
    }
}

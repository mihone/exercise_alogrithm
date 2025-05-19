package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LCR 056. 两数之和 IV - 输入二叉搜索树
*  @author mihone
*  @since 2025/5/19 21:48
*/
public class LCR056 {

    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {
        return inorder(root, k, new HashMap<>());
    }

    public boolean inorder(TreeNode root, int k, Map<Integer,TreeNode> map) {
        if (root == null) {
            return false;
        }
        boolean inorder = inorder(root.left, k, map);
        if (inorder) {
            return true;
        }
        TreeNode n = map.get(k - root.val);
        if (n!=null) {
            return true;
        }
        map.put(root.val, root);
        return inorder(root.right, k,map);

    }

}

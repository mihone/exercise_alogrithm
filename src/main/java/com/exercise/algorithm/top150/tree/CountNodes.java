package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.TreeNode;

/**
 * [ENHANCE]
 * 222. 完全二叉树的节点个数
*  @author mihone
*  @since 2024/12/31 20:09
*/
public class CountNodes {

    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        // 沿最左侧和最右侧分别计算高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // 如果左右侧计算的高度相同，则是一棵满二叉树
        if (hl == hr) {
            return (int)Math.pow(2, hl) - 1;
        }
        // 如果左右侧的高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}

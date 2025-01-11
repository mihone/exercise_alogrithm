package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
*  @author mihone
*  @since 2025/1/8 22:07
*/
public class IsValidBST {

    public static void main(String[] args) {

    }
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> v = new ArrayList<>();
        isValidBST(root,v);
        int pre = v.get(0);
        for (int i = 1; i < v.size(); i++) {
            if (v.get(i)<=pre) {
                return false;
            }
            pre = v.get(i);
        }
        return true;
    }

    public void isValidBST(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        isValidBST(root.left, values);
        values.add(root.val);
        isValidBST(root.right, values);


    }


    //第二种，中序遍历同时，存储上一个节点的值即可进行比较。
    boolean res=true;
    long prev=Integer.MIN_VALUE-1L;
    public boolean isValidBST2(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node){
        if(!res||node==null)return;
        dfs(node.left);
        if(node.val<=prev){
            res=false;
            return;
        }
        prev=node.val;
        dfs(node.right);
    }

}

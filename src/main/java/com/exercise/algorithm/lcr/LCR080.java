package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

/**
 * LCR 080. 组合
*  @author mihone
*  @since 2025/9/22 22:09
*/
public class LCR080 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = 0; i < 1 << n; i++) {
            List<Integer> part = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((1<<j) & i) !=0) {
                    part.add(j+1);
                }
            }
            if (part.size() ==k) {
                res.add(part);
            }

        }
        return res;

    }

    public List<List<Integer>> combine2(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> part = new ArrayList<>();
        dfs(res, part, nums, k, 0);
        return res;

    }

    public void dfs(List<List<Integer>> res, List<Integer> part ,int[] nums, int k,int cur){
        if (part.size() == k) {
            res.add(new ArrayList<>(part));
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            part.add(nums[i]);
            dfs(res, part , nums, k, i+1);
            part.remove(part.size()-1);
        }
    }
}

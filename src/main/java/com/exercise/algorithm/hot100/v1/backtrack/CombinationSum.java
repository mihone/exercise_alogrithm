package com.exercise.algorithm.hot100.v1.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [ENHANCE]
 * 39. 组合总和
*  @author mihone
*  @since 2025/3/3 20:11
*/
public class CombinationSum {

    public static void main(String[] args) {

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target<=0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        combinationSum(candidates, target,0, part, res);
        return res;

    }
    public void combinationSum(int[] candidates, int target,int cur,List<Integer> part,List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<>(part));
            return;
        }
        if (target<0) {
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (candidates[i]>target) {
                break;
            }
            part.add(candidates[i]);
            combinationSum(candidates, target-candidates[i],i, part, ret);
            part.remove(part.size()-1);
        }

    }
}

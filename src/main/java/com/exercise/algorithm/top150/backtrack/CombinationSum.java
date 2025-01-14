package com.exercise.algorithm.top150.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author mihone
 * @since 2025/1/13 21:28
 */
public class CombinationSum {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        back(candidates, target,0, new ArrayList<>(), ret);
        return ret;
    }

    public void back(int[] candidates, int target, int cur,List<Integer> part, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<>(part));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            part.add(candidates[i]);
            back(candidates, target - candidates[i],i, part, ret);
            part.remove(part.size() - 1);
        }

    }
}

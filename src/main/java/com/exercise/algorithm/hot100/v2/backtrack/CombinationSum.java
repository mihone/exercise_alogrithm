package com.exercise.algorithm.hot100.v2.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ret = new ArrayList<>();
        combinationSum(candidates, target, new ArrayList<>(), 0, ret);
        return ret;
    }


    public void combinationSum(int[] candidates, int target, List<Integer> part, int cur, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<>(part));
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            part.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], part, i, ret);
            part.remove(part.size() - 1);
        }
    }
}

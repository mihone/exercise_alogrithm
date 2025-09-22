package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCR 081. 组合总和
 *
 * @author mihone
 * @since 2025/9/22 22:21
 */
public class LCR081 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> part = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, part, candidates, target, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> part, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                part.add(candidates[i]);
                dfs(res, part, candidates, target - candidates[i], i);
                part.remove(part.size() - 1);
            } else {
                break;
            }
        }
    }


}

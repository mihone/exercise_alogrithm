package com.exercise.algorithm.lcr;

import java.util.*;

/**
 * LCR 082. 组合总和 II
*  @author mihone
*  @since 2025/9/22 22:28
*/
public class LCR082 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> part = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, part, candidates, target, 0);
        return new ArrayList<>(res);
    }

    public void dfs(Set<List<Integer>> res, List<Integer> part, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(i>start && candidates[i]==candidates[i-1]) {
                continue;
            }
            if (candidates[i] <= target) {
                part.add(candidates[i]);
                dfs(res, part, candidates, target - candidates[i], i+1);
                part.remove(part.size() - 1);
            } else {
                break;
            }
        }
    }
}

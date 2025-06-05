package com.exercise.algorithm.hot100.v2.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ret;
        }

        for (int i = 0; i < 1 << nums.length; i++) {
            List<Integer> part = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((1 << j) & i) !=0) {
                    part.add(nums[j]);
                }
            }
            ret.add(part);
        }
        return ret;

    }
}

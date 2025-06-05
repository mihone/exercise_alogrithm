package com.exercise.algorithm.hot100.v2.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        List<Integer> part = new ArrayList<>();
        permute(nums, part, ret);
        return ret;

    }

    public void permute(int[] nums,List<Integer>part,List<List<Integer>> ret) {
        if (part.size() == nums.length) {
            ret.add(new ArrayList<>(part));
            return;
        }
        for (int num : nums) {
            if (!part.contains(num)) {
                part.add(num);
                permute(nums,part,ret);
                part.remove(part.size() - 1);
            }
        }

    }
}

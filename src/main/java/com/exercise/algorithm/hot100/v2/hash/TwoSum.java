package com.exercise.algorithm.hot100.v2.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer n = map.get(target-nums[i]);
            if (n!=null) {
                return new int[]{i, n};
            }
            map.put(nums[i], i);
        }
        return null;

    }
}

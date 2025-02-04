package com.exercise.algorithm.hot100.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
*  @author mihone
*  @since 2025/2/2 11:36
*/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer i1 = map.get(target - nums[i]);
            if (i1!=null) {
                return new int[]{i,i1};
            }
            map.put(nums[i], i);

        }
        return null;
    }

    public static void main(String[] args) {

    }
}

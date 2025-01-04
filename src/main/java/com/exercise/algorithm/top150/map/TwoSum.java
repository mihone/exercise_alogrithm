package com.exercise.algorithm.top150.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
*  @author mihone
*  @since 2024/12/7 18:11
*/
public class TwoSum {

    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}

package com.exercise.algorithm.hot100.v2.array;

public class MaxSubArray {


    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            max = Math.max(max, pre);
        }

        return max;


    }
}

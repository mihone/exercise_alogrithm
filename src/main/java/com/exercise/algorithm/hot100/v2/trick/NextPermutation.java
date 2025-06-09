package com.exercise.algorithm.hot100.v2.trick;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int peek = nums.length - 1;

        while (peek > 0 && nums[peek] <= nums[peek - 1]) {
            peek--;
        }
        if (peek == 0) {
            Arrays.sort(nums);
            return;
        }
        int i = nums.length - 1;
        while (i > peek && nums[i] <= nums[peek - 1]) {
            i--;
        }


        int temp = nums[peek - 1];
        nums[peek - 1] = nums[i];
        nums[i] = temp;
        Arrays.sort(nums, peek, nums.length);


    }
}

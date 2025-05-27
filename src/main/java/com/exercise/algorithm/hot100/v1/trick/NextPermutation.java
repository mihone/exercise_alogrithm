package com.exercise.algorithm.hot100.v1.trick;

import java.util.Arrays;

/**
 * [ENHANCE]
 * 31. 下一个排列
 *
 * @author mihone
 * @since 2025/3/16 16:33
 */
public class NextPermutation {

    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        int target = nums.length - 1;
        while (target >= 1 && nums[target] <= nums[target - 1]) {
            target--;
        }
        if (target <= 0) {
            Arrays.sort(nums);
            return;
        }
        int i = target - 1;
        int j = nums.length - 1;
        while (j > i && nums[j] <= nums[i]) {
            j--;
        }


        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        Arrays.sort(nums, i + 1, nums.length);

    }
}

package com.exercise.algorithm.lcr;

import java.util.Arrays;

/**
 * [REPEAT]
 * LCR 012. 寻找数组的中心下标
*  @author mihone
*  @since 2025/4/21 22:29
*/
public class LCR012 {

    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

}

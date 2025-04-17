package com.exercise.algorithm.lcr;

/**
 * [REPEAT]
 * LCR 009. 乘积小于 K 的子数组
 *
 * @author mihone
 * @since 2025/4/17 20:18
 */
public class LCR009 {

    public static void main(String[] args) {

    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;

    }
}

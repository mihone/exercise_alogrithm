package com.exercise.algorithm.lcr;

/**
 * LCR 008. 长度最小的子数组
 *
 * @author mihone
 * @since 2025/4/14 20:48
 */
public class LCR008 {
    public static void main(String[] args) {

    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = 10000000;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (start<=end && sum >= target) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return min > nums.length ? 0 : min;

    }


}

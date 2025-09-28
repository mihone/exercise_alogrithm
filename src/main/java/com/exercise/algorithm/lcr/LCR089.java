package com.exercise.algorithm.lcr;
/**
 * LCR 089. 打家劫舍
*  @author mihone
*  @since 2025/9/28 20:27
*/
public class LCR089 {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];

    }
}

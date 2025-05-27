package com.exercise.algorithm.hot100.v1.dp;

/**
 * 198. 打家劫舍
 *
 * @author mihone
 * @since 2025/3/10 21:24
 */
public class Rob {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        int max = 0;
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i-1] + dp[i - 2]);
        }
        return dp[nums.length];

    }
}

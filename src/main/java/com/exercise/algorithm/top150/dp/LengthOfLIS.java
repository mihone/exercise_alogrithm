package com.exercise.algorithm.top150.dp;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
*  @author mihone
*  @since 2024/12/15 18:56
*/
public class LengthOfLIS {
    public static void main(String[] args) {

    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;

    }
}

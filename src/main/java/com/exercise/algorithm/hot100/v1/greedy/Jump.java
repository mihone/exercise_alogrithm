package com.exercise.algorithm.hot100.v1.greedy;

import java.util.Arrays;

/**
 * [ENHANCE]
 * 45. 跳跃游戏 II
*  @author mihone
*  @since 2025/3/9 14:36
*/
public class Jump {
    public static void main(String[] args) {

    }
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1000000);
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] >= j - i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }

        }
        return dp[0];
    }
}

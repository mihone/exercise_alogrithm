package com.exercise.algorithm.lcr;

/**
 * [REPEAT]
 * LCR 088. 使用最小花费爬楼梯
 *
 * @author mihone
 * @since 2025/9/27 22:01
 */
public class LCR088 {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }

        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i-2], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];


    }
}

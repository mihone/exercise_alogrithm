package com.exercise.algorithm.hot100.v1.greedy;
/**
 * 121. 买卖股票的最佳时机
*  @author mihone
*  @since 2025/3/9 14:29
*/
public class MaxProfit {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];

    }
}

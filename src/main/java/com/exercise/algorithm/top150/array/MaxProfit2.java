package com.exercise.algorithm.top150.array;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author mihone
 * @since 2024/11/21 8:01
 */
public class MaxProfit2 {

    public static void main(String[] args) {
        MaxProfit2 maxProfit2 = new MaxProfit2();
    }

    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];

    }
}

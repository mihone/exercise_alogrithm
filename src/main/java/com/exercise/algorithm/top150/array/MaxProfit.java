package com.exercise.algorithm.top150.array;

/**
 * 121. 买卖股票的最佳时机
 *
 * @author mihone
 * @since 2024/11/20 8:33
 */
public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

    }
    public int maxProfit(int[] prices) {
        int[][]dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];

    }
}

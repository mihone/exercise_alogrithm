package com.exercise.algorithm.hot100.v2.greedy;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0; // 不持有股票
        dp[0][1] = -prices[0]; // 持有股票
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); // 不持有股票
            dp[i][1] = Math.max(dp[i - 1][1],  - prices[i]); // 持有股票
        }
        return dp[prices.length - 1][0]; // 最后一天不持有股票的最大利润

    }

    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            minprice = Math.min(minprice, price);
            maxprofit = Math.max(maxprofit, price - minprice);
        }
        return maxprofit;
    }

}

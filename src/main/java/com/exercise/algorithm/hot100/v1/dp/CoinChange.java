package com.exercise.algorithm.hot100.v1.dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
*  @author mihone
*  @since 2025/3/11 21:25
*/
public class CoinChange {

    public static void main(String[] args) {

    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount]==amount+1 ? -1 : dp[amount];

    }
}

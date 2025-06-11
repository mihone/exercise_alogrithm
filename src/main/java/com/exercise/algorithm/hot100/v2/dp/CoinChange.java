package com.exercise.algorithm.hot100.v2.dp;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] ret = new int[amount + 1];
        Arrays.fill(ret, amount + 1);
        ret[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    ret[i] = Math.min(ret[i], ret[i - coin] + 1);
                }
            }
        }
        return ret[amount] == amount + 1 ? -1 : ret[amount];

    }
}

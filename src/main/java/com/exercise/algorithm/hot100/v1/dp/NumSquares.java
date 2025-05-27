package com.exercise.algorithm.hot100.v1.dp;
/**
 * 279. 完全平方数
*  @author mihone
*  @since 2025/3/11 21:15
*/
public class NumSquares {
    public static void main(String[] args) {

    }
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);

            }
        }
        return dp[n];

    }
}

package com.exercise.algorithm.hot100.v2.dp;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int s1 = text1.length();
        int s2 = text2.length();
        int[][] dp = new int[s1 + 1][s2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= s1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= s2; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1][s2];


    }
}

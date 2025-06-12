package com.exercise.algorithm.hot100.v2.dp;

public class MinDistance {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int add1 = dp[i][j - 1] + 1;
                int add2 = dp[i-1][j] + 1;
                int replace = dp[i - 1][j - 1] ;
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    replace += 1;
                }
                dp[i][j] = Math.min(Math.min(add1, add2), replace);

            }
        }
        return dp[word1.length()][word2.length()];

    }
}

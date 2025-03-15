package com.exercise.algorithm.hot100.dp;

/**
 * 72. 编辑距离
 *
 * @author mihone
 * @since 2025/3/15 11:04
 */
public class MinDistance {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        if (word1 == null) {
            return word2 == null ? 0 : word2.length();
        }
        if (word2 == null) {
            return word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int i1 = dp[i - 1][j]+1;
                int i2 = dp[i ][j- 1]+1;
                int i3 = dp[i - 1][j- 1];
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    i3++;
                }
                dp[i][j] = Math.min(Math.min(i1, i2), i3)+1;
            }
        }
        return dp[word1.length()][word2.length()];

    }
}

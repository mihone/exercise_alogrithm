package com.exercise.algorithm.hot100.dp;
/**
 * [REPEAT]
 * 1143. 最长公共子序列
*  @author mihone
*  @since 2025/3/15 11:13
*/
public class LongestCommonSubsequence {
    public static void main(String[] args) {

    }
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length()<=0 || text2.length()<=0) {
            return 0;
        }
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

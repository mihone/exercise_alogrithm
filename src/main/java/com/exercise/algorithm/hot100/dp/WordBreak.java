package com.exercise.algorithm.hot100.dp;

import java.util.List;

/**
 * 139. 单词拆分
*  @author mihone
*  @since 2025/3/12 20:18
*/
public class WordBreak {
    public static void main(String[] args) {

    }
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            for (String word : wordDict) {
                if (dp[i]) {
                    break;
                }
                if (substring.endsWith(word)) {
                    dp[i] = dp[i - word.length()];
                }
            }
        }
        return dp[s.length()];

    }
}

package com.exercise.algorithm.top150.dp;

import java.util.List;

/**
 * 139. 单词拆分
 *
 * @author mihone
 * @since 2024/12/15 18:22
 */
public class WordBreak {
    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            for (String w : wordDict) {
                dp[i] = substring.endsWith(w) && substring.length() - w.length() >= 0 && dp[substring.length() - w.length()];
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];

    }
}

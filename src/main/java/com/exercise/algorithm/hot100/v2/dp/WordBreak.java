package com.exercise.algorithm.hot100.v2.dp;

import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] ret = new boolean[s.length() + 1];
        ret[0] = true;

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i + 1);
            for (String word : wordDict) {
                if (str.endsWith(word)) {
                    ret[i+1] = ret[i+1] || ret[i + 1 - word.length()];
                    if (ret[i+1]) {
                        break;
                    }
                }
            }
        }
        return ret[s.length()];
    }
}

package com.exercise.algorithm.top150.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
*  @author mihone
*  @since 2024/12/11 21:25
*/
public class WordPattern {
    public static void main(String[] args) {

    }

    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        int m = s.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && s.charAt(j) != ' ') {
                j++;
            }
            String tmp = s.substring(i, j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;

    }
}

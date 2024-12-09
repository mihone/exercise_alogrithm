package com.exercise.algorithm.top150.map;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
*  @author mihone
*  @since 2024/12/7 17:58
*/
public class IsAnagram {

    public static void main(String[] args) {

    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }
}

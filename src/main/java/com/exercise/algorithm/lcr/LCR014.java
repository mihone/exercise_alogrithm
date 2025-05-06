package com.exercise.algorithm.lcr;

import java.util.Arrays;

/**
 * LCR 014. 字符串的排列
 *
 * @author mihone
 * @since 2025/5/4 10:52
 */
public class LCR014 {

    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Array[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            s2Array[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s1Array, s2Array)) {
            return true;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            s2Array[s2.charAt(i) - 'a']--;
            s2Array[s2.charAt(i + s1.length()) - 'a']++;
            if (Arrays.equals(s1Array, s2Array)) {
                return true;
            }
        }
        return false;
    }
}

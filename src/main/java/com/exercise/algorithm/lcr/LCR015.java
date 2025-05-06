package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LCR 015. 找到字符串中所有字母异位词
*  @author mihone
*  @since 2025/5/4 11:23
*/
public class LCR015 {

    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        if (p == null || p.length() == 0 || s == null || s.length() == 0 || p.length() > s.length()) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<Integer>();
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sArr, pArr)) {
            result.add(0);
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            sArr[s.charAt(i) - 'a']--;
            sArr[s.charAt(p.length() + i) - 'a']++;
            if (Arrays.equals(sArr, pArr)) {
                result.add(i + 1);
            }

        }
        return result;
    }
}

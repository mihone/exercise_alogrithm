package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LCR 032. 有效的字母异位词
*  @author mihone
*  @since 2025/5/13 20:40
*/
public class LCR032 {


    public boolean isAnagram(String s, String t) {
        if (t == null || t.length() == 0 || s == null || s.length() == 0 || t.length() > s.length()) {
            return false;
        }
        //不完全相同为true
        if (s.equals(t)) {
            return false;
        }
        List<Integer> result = new ArrayList<Integer>();
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for (int i = 0; i < t.length(); i++) {
            tArr[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
        }

        return Arrays.equals(sArr, tArr);

    }
}

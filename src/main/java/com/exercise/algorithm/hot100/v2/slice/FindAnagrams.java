package com.exercise.algorithm.hot100.v2.slice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {


    // 找到s中所有p的异位词子串
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        int[] sArr = new int[26];
        int[] pArr = new int[26];

        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sArr, pArr)) {
            ret.add(0);
        }

        for (int j = 0; j < s.length() - p.length(); j++) {
            sArr[s.charAt(j) - 'a']--;
            sArr[s.charAt(j + p.length()) - 'a']++;
            if (Arrays.equals(sArr, pArr)) {
                ret.add(j + 1);
            }

        }

        return ret;

    }
}

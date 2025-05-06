package com.exercise.algorithm.lcr;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * LCR 016. 无重复字符的最长子串
*  @author mihone
*  @since 2025/5/6 20:13
*/
public class LCR016 {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int ret = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer oldIndex = map.get(c);
            if (oldIndex != null) {
                while (start <= oldIndex) {
                    start++;
                }
            }
            map.put(c, i);
            ret = Math.max(ret, i - start + 1);

        }
        return ret;

    }
}

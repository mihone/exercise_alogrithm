package com.exercise.algorithm.hot100.slice;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
*  @author mihone
*  @since 2025/2/3 14:24
*/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {

    }
    //abba
    public int lengthOfLongestSubstring(String s) {
        if (s == null | s.length() == 0) {
            return 0;
        }

        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        int sIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer i1 = map.get(c);
            if (i1 != null) {
                for (int j = sIndex; j < i1; j++) {
                    map.remove(s.charAt(j));
                }
                sIndex = i1 + 1;

            }
            map.put(c,i);
            max = Math.max(max,i-sIndex+1);
        }
        return max;


    }
}

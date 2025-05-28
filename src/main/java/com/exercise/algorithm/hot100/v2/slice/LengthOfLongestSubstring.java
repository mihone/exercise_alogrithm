package com.exercise.algorithm.hot100.v2.slice;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        int ret = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.get(s.charAt(i));
            if (index!=null) {

                for (int j = start; j <= index; j++) {
                    map.remove(s.charAt(j));
                }
                start = index + 1;

            }

            map.put(s.charAt(i), i);
            ret = Math.max(ret, i - start+1);


        }
        return ret;

    }
}

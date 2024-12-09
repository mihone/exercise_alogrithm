package com.exercise.algorithm.top150.slice;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
*  @author mihone
*  @since 2024/12/7 16:41
*/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {

    }

    //abcabcbb
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int pre = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (index == null) {
                map.put(c, i);
            }else {
                while (pre<=index){
                    map.remove(s.charAt(pre));
                    pre++;
                }
                map.put(c, i);
            }
            max = Math.max(max, i - pre+1);

        }
        return max;

    }

}

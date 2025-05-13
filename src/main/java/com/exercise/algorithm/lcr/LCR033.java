package com.exercise.algorithm.lcr;

import java.util.*;

/**
 * LCR 033. 字母异位词分组
*  @author mihone
*  @since 2025/5/13 20:52
*/
public class LCR033 {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<List<String>>();

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = String.valueOf(charArray);
            List<String> strings = map.get(s);
            if (strings == null) {
                strings = new ArrayList<>();
                map.put(s, strings);
            }
            strings.add(str);
        }
        return new ArrayList<>(map.values());

    }
}

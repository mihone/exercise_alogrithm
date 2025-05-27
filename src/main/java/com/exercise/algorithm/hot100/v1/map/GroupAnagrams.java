package com.exercise.algorithm.hot100.v1.map;

import java.util.*;

/**
 * 49. 字母异位词分组
*  @author mihone
*  @since 2025/2/3 10:09
*/
public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> strings = map.get(key);
            if (strings == null) {
                strings = new ArrayList<>();
                map.put(key, strings);
            }
            strings.add(str);
        }
        return new ArrayList<>(map.values());

    }
}

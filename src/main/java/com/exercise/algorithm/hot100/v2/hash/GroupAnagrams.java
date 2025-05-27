package com.exercise.algorithm.hot100.v2.hash;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            List<String> strings = map.get(sortedStr);
            if (strings == null) {
                strings = new ArrayList<>();
                map.put(sortedStr, strings);
            }
            strings.add(str);
        }
        return new ArrayList<>(map.values());
    }
}

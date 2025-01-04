package com.exercise.algorithm.top150.map;

import java.util.*;

/**
 * 49. 字母异位词分组
*  @author mihone
*  @since 2024/12/7 18:01
*/
public class GroupAnagrams {

    public static void main(String[] args) {

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}

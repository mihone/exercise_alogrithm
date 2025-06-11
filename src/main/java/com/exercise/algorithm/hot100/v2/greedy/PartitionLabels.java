package com.exercise.algorithm.hot100.v2.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), Math.max(map.getOrDefault(s.charAt(i), 0), i));
        }

        List<Integer> ret = new ArrayList<>();
        int end = map.get(s.charAt(0));
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
                ret.add(end- start+1);
                start = end + 1;
            }
        }
        return ret;

    }
}

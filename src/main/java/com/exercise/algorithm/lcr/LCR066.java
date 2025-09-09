package com.exercise.algorithm.lcr;

import java.util.HashMap;
import java.util.Map;

/**
 * LCR 066. 键值映射
*  @author mihone
*  @since 2025/9/9 21:47
*/
public class LCR066 {

    public static void main(String[] args) {

    }

    class MapSum {

        Map<String,Integer> map ;

        /** Initialize your data structure here. */
        public MapSum() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);

        }

        public int sum(String prefix) {
            int sum = 0;
            for (String key : map.keySet()) {
                if (key.startsWith(prefix)) {
                    sum += map.get(key);
                }

            }
            return sum;

        }
    }

}

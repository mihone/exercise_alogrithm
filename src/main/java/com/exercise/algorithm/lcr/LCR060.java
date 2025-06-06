package com.exercise.algorithm.lcr;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LCR 060. 前 K 个高频元素
*  @author mihone
*  @since 2025/5/21 21:09
*/
public class LCR060 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> o2[1] - o1[1]);
        map.forEach((key,v)-> queue.offer(new int[]{key, v}));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];

        }
        return res;

    }


}

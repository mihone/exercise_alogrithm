package com.exercise.algorithm.hot100.v1.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
*  @author mihone
*  @since 2025/3/9 13:04
*/
public class TopKFrequent {
    public static void main(String[] args) {

    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, (o1, o2) -> o2[1] - o1[1]);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.getOrDefault(nums[i],0);
            count++;
            map.put(nums[i], count);
        }
        map.forEach((key,v)->{
            pq.offer(new int[]{key,v});
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                res[i] = pq.poll()[0];
            }
        }
        return res;

    }
}

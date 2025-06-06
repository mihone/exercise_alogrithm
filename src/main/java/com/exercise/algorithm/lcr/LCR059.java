package com.exercise.algorithm.lcr;

import java.util.PriorityQueue;

/**
 * [ENHANCE]
 * LCR 059. 数据流中的第 K 大元素
*  @author mihone
*  @since 2025/5/21 20:58
*/
public class LCR059 {

    public static void main(String[] args) {
        LCR059 lcr059 = new LCR059();
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));

    }

    static class KthLargest {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int x : nums) {
                add(x);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }

    }
}

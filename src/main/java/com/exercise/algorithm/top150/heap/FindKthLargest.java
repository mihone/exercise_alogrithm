package com.exercise.algorithm.top150.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
*  @author mihone
*  @since 2025/1/19 11:23
*/
public class FindKthLargest {
    public static void main(String[] args) {

    }
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>( (o1, o2) -> o2 - o1);
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.peek();

    }
}

package com.exercise.algorithm.lcr;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * LCR 076. 数组中的第 K 个最大元素
*  @author mihone
*  @since 2025/9/17 21:53
*/
public class LCR076 {

    public int findKthLargest0(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i]>queue.peek()) {
                queue.poll();
            queue.offer(nums[i]);
            }

        }
       return queue.peek();


    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;
        Random random = new Random();
        int r = random.nextInt(right - left + 1);
        int pivot = left + r;
        int pVal = nums[pivot];
        nums[pivot] = nums[start];
        nums[start] = pVal;
        while (left < right) {
            while (left < right  && nums[right] <= pVal) {
                right--;
            }
            while (left < right  && nums[left] >= pVal) {
                left++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        int temp = nums[left];
        nums[left] = pVal;
        nums[start] = temp;

        if (left == k - 1) {
            return nums[left];
        }
        if (left < k - 1) {
            return findKthLargest(nums, left + 1, end, k);
        } else {
            return findKthLargest(nums, start, left - 1, k);
        }
    }
}

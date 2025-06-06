package com.exercise.algorithm.hot100.v2.heap;

import java.util.PriorityQueue;
import java.util.Random;

public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest.findKthLargest(nums, k)); // 5
    }

//    public int findKthLargest(int[] nums, int k) {
//        if (nums.length==0) {
//            return 0;
//        }
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o2-o1);
//        for (int num : nums) {
//            if (queue.size()<nums.length-k+1) {
//                queue.offer(num);
//            }else {
//                if (queue.peek()>num) {
//                    queue.poll();
//                    queue.offer(num);
//                }
//            }
//
//        }
//        return queue.peek();
//
//    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;
        Random random = new Random();
        int r = random.nextInt(right - left + 1);
        int pivot = left + r;
        while (left < right) {
            while (left < right  && nums[left] >= nums[pivot]) {
                left++;
            }

            while (left < right  && nums[right] <= nums[pivot]) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        int temp = nums[left];
        nums[left] = nums[pivot];
        nums[pivot] = temp;

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

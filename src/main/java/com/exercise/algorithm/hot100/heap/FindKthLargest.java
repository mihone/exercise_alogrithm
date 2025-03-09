package com.exercise.algorithm.hot100.heap;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * [REPEAT]
 * 215. 数组中的第K个最大元素
 *
 * @author mihone
 * @since 2025/3/9 12:53
 */
public class FindKthLargest {

    public int quickselect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) return quickselect(nums, l, j, k);
        else return quickselect(nums, j + 1, r, k);
    }
    public int findKthLargest(int[] _nums, int k) {
        int n = _nums.length;
        return quickselect(_nums, 0, n - 1, n - k);
    }

//    public int findKthLargest(int[] nums, int k) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//        if (nums.length < k) {
//            return -1;
//        }
//        return internal(nums, k, 0, nums.length-1);
//
//
//    }
//
//    public int internal(int[] nums, int k, int start, int end) {
//        if (start >= end) {
//            return nums[k];
//        }
//        int length = end - start + 1;
//        int i = new Random().nextInt(length);
//        int pivot = start + i;
//        int pivotVal = nums[start + i];
//        int left = start;
//        int right = end;
//        while (left <= right) {
//            while (left < right && nums[left] <= pivotVal) {
//                left++;
//            }
//            while (left < right && nums[right] > pivotVal) {
//                right--;
//            }
//            if (left < right) {
//                int temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
//            }
//        }
//        if (k > right) {
//            return internal(nums, k, start, right);
//
//        } else {
//            return internal(nums, k, left, end);
//        }
//
//
//    }
//    public int findKthLargest(int[] nums, int k) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//        if (nums.length < k) {
//            return -1;
//        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
//        for (int i = 0; i < nums.length; i++) {
//            queue.offer(nums[i]);
//        }
//        for (int i = 0; i < k - 1; i++) {
//            queue.poll();
//        }
//        return queue.peek();
//
//    }

    public static void main(String[] args) {

    }
}

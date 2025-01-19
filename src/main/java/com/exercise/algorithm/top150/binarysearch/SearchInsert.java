package com.exercise.algorithm.top150.binarysearch;

/**
 * @author mihone
 * @since 2025/1/18 11:07
 */
public class SearchInsert {

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;


    }

}

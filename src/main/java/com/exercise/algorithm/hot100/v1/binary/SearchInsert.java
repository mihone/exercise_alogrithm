package com.exercise.algorithm.hot100.v1.binary;

/**
 * [ENHANCE]
 * 35. 搜索插入位置
 *
 * @author mihone
 * @since 2025/3/5 21:45
 */
public class SearchInsert {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + 1;

    }
}

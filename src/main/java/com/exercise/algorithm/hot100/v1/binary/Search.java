package com.exercise.algorithm.hot100.v1.binary;
/**
 * [REPEAT]
 * 33. 搜索旋转排序数组
*  @author mihone
*  @since 2025/3/6 20:47
*/
public class Search {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[right]) {
                if (nums[right] >= target && nums[mid] < target) {
                    left = mid + 1;

                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }

        }
        return -1;

    }

}

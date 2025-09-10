package com.exercise.algorithm.lcr;
/**
 * LCR 068. 搜索插入位置
*  @author mihone
*  @since 2025/9/10 21:48
*/
public class LCR068 {

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

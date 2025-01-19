package com.exercise.algorithm.top150.binarysearch;
/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
*  @author mihone
*  @since 2025/1/19 10:42
*/
public class SearchRange {
    public static void main(String[] args) {

    }
    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int l = mid;
                int r = mid;
                while (l >= 0 && nums[l] == target) {
                    l--;
                }
                while (r < nums.length && nums[r] == target) {
                    r++;
                }
                return new int[]{l+1, r-1};

            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};

    }
}

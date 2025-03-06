package com.exercise.algorithm.hot100.binary;
/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
*  @author mihone
*  @since 2025/3/6 20:41
*/
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                int l = mid; int r = mid;
                while (l >=0 && nums[l] == target) {
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

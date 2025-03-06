package com.exercise.algorithm.hot100.binary;
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
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                if (nums[right] == target) {
                    return right;
                }
                if (nums[right]>target) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                if (nums[left] == target) {
                    return left;
                }
                if (nums[left]<target) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }

        }
        return -1;

    }

}

package com.exercise.algorithm.hot100.array;
/**
 * 189. 轮转数组
*  @author mihone
*  @since 2025/2/3 16:52
*/
public class Rotate {
    public static void main(String[] args) {

    }
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse (int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

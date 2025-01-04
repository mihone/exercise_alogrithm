package com.exercise.algorithm.top150.array;

/**
 * 189. 轮转数组
 *
 * @author mihone
 * @since 2024/11/20 8:19
 */
public class Rotate {

    public static void main(String[] args) {
        Rotate rotate = new Rotate();

    }

    public void rotate(int[] nums, int k) {
        if (k <= 0) {
            return;
        }
        if (nums.length == 0) {
            return;
        }
        k = k % nums.length;
        if (k==0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);


    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}

package com.exercise.algorithm.hot100.array;
/**
 * 53. 最大子数组和
*  @author mihone
*  @since 2025/2/3 16:24
*/
public class MaxSubArray {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {

        int[] max = new int[nums.length];
        int r = nums[0];
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1] + nums[i], nums[i]);
            r = Math.max(r, max[i]);
        }
        return r;
    }
}

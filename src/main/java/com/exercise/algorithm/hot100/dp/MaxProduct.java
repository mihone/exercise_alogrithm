package com.exercise.algorithm.hot100.dp;
/**
 * [REPEAT]
 * 152. 乘积最大子数组
*  @author mihone
*  @since 2025/3/13 20:08
*/
public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(-1 << 31);
    }
    public int maxProduct(int[] nums) {
        int length = nums.length;
        long[] maxF = new long[length];
        long[] minF = new long[length];
        for (int i = 0; i < length; i++) {
            maxF[i] = nums[i];
            minF[i] = nums[i];
        }
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
//            if (minF[i] < (-1 << 31)) {
//                minF[i] = nums[i];
//            }
        }
        int ans = (int) maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, (int) maxF[i]);
        }
        return ans;
    }

}

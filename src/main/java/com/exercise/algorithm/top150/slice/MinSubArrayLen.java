package com.exercise.algorithm.top150.slice;
/**
 * [ENHANCE]
 * 209. 长度最小的子数组
*  @author mihone
*  @since 2024/12/7 16:28
*/
public class MinSubArrayLen {
    public static void main(String[] args) {

    }

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


}

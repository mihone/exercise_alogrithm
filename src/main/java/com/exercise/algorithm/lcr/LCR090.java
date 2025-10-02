package com.exercise.algorithm.lcr;
/**
 * LCR 090. 打家劫舍 II
*  @author mihone
*  @since 2025/10/2 10:10
*/
public class LCR090 {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[][] dp = new int[nums.length][2];
        //第一个房间不偷
        dp[0][0] = 0;
        dp[1][0] = nums[1];
        //第一个房间偷
        dp[0][1] = nums[0];
        dp[1][1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], nums[i] + dp[i - 2][0]);
            if (i!=nums.length-1) {
                dp[i][1] = Math.max(dp[i - 1][1], nums[i] + dp[i - 2][1]);
            }else {
                dp[i][1] = dp[i-1][1];
            }
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}

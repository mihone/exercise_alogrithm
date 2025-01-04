package com.exercise.algorithm.top150.array;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 *
 * @author mihone
 * @since 2024/11/21 8:11
 */
public class CanJump2 {

    public static void main(String[] args) {
        CanJump2 canJump2 = new CanJump2();
        System.out.println(canJump2.jump(new int[]{2,3,0,1,4}));
    }

    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 10000);
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= j - i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[0];
    }
}

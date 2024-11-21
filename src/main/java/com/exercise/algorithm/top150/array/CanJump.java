package com.exercise.algorithm.top150.array;

/**
 * 55. 跳跃游戏
 *
 * @author mihone
 * @since 2024/11/21 8:04
 */
public class CanJump {

    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (!dp[i]) {
                    dp[i] = dp[j] && nums[i] >= (j - i);
                }
            }
        }
        return dp[0];

    }
}

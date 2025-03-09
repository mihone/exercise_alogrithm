package com.exercise.algorithm.hot100.greedy;

/**
 * 55. 跳跃游戏
 *
 * @author mihone
 * @since 2025/3/9 14:31
 */
public class CanJump {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (dp[i]) {
                    break;
                }
                dp[i] = nums[i] >= j - i && dp[j];
            }

        }
        return dp[0];

    }
}

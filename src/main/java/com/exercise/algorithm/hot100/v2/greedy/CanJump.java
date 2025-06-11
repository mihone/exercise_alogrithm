package com.exercise.algorithm.hot100.v2.greedy;

public class CanJump {

    public boolean canJump(int[] nums) {

        boolean[] ret = new boolean[nums.length];
        ret[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (ret[i]) {
                    break;
                }
                ret[i] = ret[i] || (nums[i] >= j - i && ret[j]);

            }

        }

        return ret[0];

    }
}

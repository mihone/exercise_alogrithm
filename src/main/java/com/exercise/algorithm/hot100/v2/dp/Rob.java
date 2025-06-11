package com.exercise.algorithm.hot100.v2.dp;

public class Rob {

    public int rob(int[] nums) {

        int[][] ret = new int[nums.length][2];
        ret[0][0] =0 ;
        ret[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret[i][0] = Math.max(ret[i - 1][0], ret[i - 1][1]);
            ret[i][1] = ret[i - 1][0] + nums[i];
        }
        return Math.max(ret[nums.length - 1][0], ret[nums.length - 1][1]);

    }
}

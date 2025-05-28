package com.exercise.algorithm.hot100.v2.array;

import java.util.Arrays;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] ret = new int[nums.length];
        Arrays.fill(ret, 1);
        //1 2 3 4
        //1 1 2 6
        for (int i = 1; i < nums.length; i++) {
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            r = r * nums[i + 1];
            ret[i] = ret[i] * r;
        }
        return ret;
    }
}

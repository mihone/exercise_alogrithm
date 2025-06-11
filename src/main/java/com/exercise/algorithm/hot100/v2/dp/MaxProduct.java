package com.exercise.algorithm.hot100.v2.dp;

import java.util.Arrays;
/**
 * [ENHANCE]
*  @author xinyux
*  @since 2025/6/11 20:06
*/
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);
        min[0] = nums[0];
        max[0] = nums[0];

        int ans = max[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(Math.min(min[i - 1] * nums[i], nums[i]), max[i - 1] * nums[i]);
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], nums[i]), min[i - 1] * nums[i]);
            ans = Math.max(ans, max[i]);
        }
        return ans;

    }
}

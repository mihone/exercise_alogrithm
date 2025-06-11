package com.exercise.algorithm.hot100.v2.dp;

import java.util.Arrays;
/**
 * [ENHANCE]
*  @author mihone
*  @since 2025/6/11 19:56
*/
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        //以x元素结尾的递增子序列，最长的个数
        int[] ret = new int[nums.length ];
        Arrays.fill(ret, 1); // 每个元素至少可以单独构成一个递增子序列
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    ret[i] = Math.max(ret[i], ret[j] + 1);
                    max = Math.max(max, ret[i]);
                }
            }
        }
        return max;

    }
}

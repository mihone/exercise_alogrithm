package com.exercise.algorithm.lcr;
/**
 *
 * LCR 070. 有序数组中的单一元素
*  @author mihone
*  @since 2025/9/11 21:04
*/
public class LCR070 {

    public int singleNonDuplicate(int[] nums) {

        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret = ret ^ nums[i];
        }
        return ret;

    }
}

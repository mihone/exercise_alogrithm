package com.exercise.algorithm.top150.bit;
/**
 * 136. 只出现一次的数字
*  @author mihone
*  @since 2025/1/7 21:13
*/
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;

    }

    public static void main(String[] args) {

    }
}

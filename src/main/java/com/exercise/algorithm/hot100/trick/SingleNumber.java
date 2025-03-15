package com.exercise.algorithm.hot100.trick;
/**
 * 136. 只出现一次的数字
*  @author mihone
*  @since 2025/3/15 11:23
*/
public class SingleNumber {

    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int num : nums) {
            r = r ^ num;
        }
        return r;

    }
}

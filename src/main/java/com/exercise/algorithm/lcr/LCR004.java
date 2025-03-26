package com.exercise.algorithm.lcr;
/**
 * [ENHANCE]
 * LCR 004. 只出现一次的数字 II
*  @author mihone
*  @since 2025/3/26 22:13
*/
public class LCR004 {

    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

}

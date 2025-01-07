package com.exercise.algorithm.top150.bit;
/**
 * [REPEAT]
 * 137. 只出现一次的数字 II
*  @author mihone
*  @since 2025/1/7 21:15
*/
public class SingleNumber2 {
    public static void main(String[] args) {

    }

//    O(nlogC) 时间复杂度 C 是元素的数据范围，在本题中 logC=log2^32 =32，也就是我们需要遍历第 0∼31 个二进制位。
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

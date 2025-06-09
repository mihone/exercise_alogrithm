package com.exercise.algorithm.hot100.v2.trick;

public class SingleNumber {


    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // 使用异或操作
        }
        return result; // 返回只出现一次的数字

    }
}

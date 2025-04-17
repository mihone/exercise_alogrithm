package com.exercise.algorithm.lcr;

import java.util.HashMap;

/**
 * [REPEAT]
 * LCR 010. 和为 K 的子数组
 *
 * @author mihone
 * @since 2025/4/17 21:34
 */
public class LCR010 {

    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap< >();
        //代表数组本身是一种情况
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;

    }
}

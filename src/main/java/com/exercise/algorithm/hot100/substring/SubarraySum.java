package com.exercise.algorithm.hot100.substring;

import java.util.Arrays;
import java.util.HashMap;

/**
 * [REPEAT]
 * 560. 和为 K 的子数组
*  @author mihone
*  @since 2025/2/3 14:45
*/
public class SubarraySum {

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        subarraySum.subarraySumPre(new int[]{1,1,1}, 2);
    }
    public int subarraySum(int[] nums, int k) {
        if (nums.length==0) {
            return 0;
        }

        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int ssum = sum;
            if (ssum == k) {
                count++;
            }
            for (int j = 0; j < i; j++) {
                ssum -= nums[j];
                if (ssum == k) {
                    count++;
                }
            }
        }

        return count;

    }
//方法二：前缀和 + 哈希表优化
    public int subarraySumPre(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap< >();
        //代表所有前缀加起来刚好是一种情况
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

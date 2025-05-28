package com.exercise.algorithm.hot100.v2.slice;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * [REPEAT]
*  @author mihone
*  @since 2025/5/28 18:45
*/
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap < > ();
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

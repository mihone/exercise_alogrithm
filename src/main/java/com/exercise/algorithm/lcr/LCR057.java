package com.exercise.algorithm.lcr;

import java.util.Map;
import java.util.TreeSet;

/**
 * [REPEAT] !!!!!!!
 * LCR 057. 存在重复元素 III
*  @author mihone
*  @since 2025/5/19 21:57
*/
public class LCR057 {

    public static void main(String[] args) {

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }



}

package com.exercise.algorithm.hot100.map;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
*  @author mihone
*  @since 2025/2/3 11:04
*/
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int n = num;
                int count = 0;
                while (set.contains(n)) {
                    count++;
                    n = n + 1;
                }
                max = Math.max(max, count);

            }
        }
        return max;

    }
}

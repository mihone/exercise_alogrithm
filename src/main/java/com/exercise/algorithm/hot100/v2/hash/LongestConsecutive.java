package com.exercise.algorithm.hot100.v2.hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {

        int count = 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);

        }

        for (int num : set) {
            if (!set.contains(num+1)) {
                int n = num;
                int c = 0;
                while (set.contains(n)){
                    c++;
                    n--;
                }
                count = Math.max(count, c);

            }
        }
        return count;

    }


}

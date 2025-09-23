package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

/**
 * LCR 083. 全排列
*  @author mihone
*  @since 2025/9/23 21:06
*/
public class LCR083 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> part = new ArrayList<>();

        internal(ret, part, nums);
        return ret;
    }

    private void internal(List<List<Integer>> ret, List<Integer> part, int[] nums) {
        if (part.size() == nums.length) {
            ret.add(new ArrayList<>(part));
            return;
        }
        for (int num : nums) {
            if (!part.contains(num)) {
                part.add(num);
                internal(ret, part, nums);
                part.remove(part.size() - 1);
            }

        }


    }
}

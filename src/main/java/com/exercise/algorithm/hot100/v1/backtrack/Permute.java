package com.exercise.algorithm.hot100.v1.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
*  @author mihone
*  @since 2025/2/9 17:00
*/
public class Permute {

    public static void main(String[] args) {

    }

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

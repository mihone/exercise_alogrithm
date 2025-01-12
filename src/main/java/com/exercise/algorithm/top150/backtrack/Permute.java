package com.exercise.algorithm.top150.backtrack;

import java.util.*;

/**
 * @author mihone
 * @since 2025/1/11 14:08
 */
public class Permute {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        back(nums, new ArrayList<>(), res);
        return res;

    }

    public void back(int[] nums, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) {

            if (!temp.contains(num)) {
                temp.add(num);
                back(nums, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

}

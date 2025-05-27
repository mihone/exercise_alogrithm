package com.exercise.algorithm.hot100.v1.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * [ENHANCE]
 * 78. 子集
 *
 * @author mihone
 * @since 2025/2/9 17:07
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int length = nums.length;
        for (int i = 0; i < 1 << length; i++) {
            List<Integer> part = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if (((1 << j) & i) !=0) {
                    part.add(nums[j]);
                }
            }
            ret.add(part);
        }
        return ret;

    }

    public static void main(String[] args) {
        //1<<0 等于1
        System.out.println(1<<0);

    }

}

package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;
/**
 * LCR 079. 子集
*  @author mihone
*  @since 2025/9/22 22:02
*/
public class LCR079 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < 1<<nums.length; i++) {
            List<Integer> part = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((1<<j) & i) !=0) {
                    part.add(nums[j]);
                }
            }
            res.add(part);
        }
        return res;
    }
}

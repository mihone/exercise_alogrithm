package com.exercise.algorithm.top150.zone;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
*  @author mihone
*  @since 2024/12/9 20:55
*/
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null ||nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();

        int pre = nums[0];
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre + 1) {
                pre = nums[i];
            }else {
                if (start == pre) {
                    result.add(start + "");
                }else {
                    result.add(start + "->" + pre);
                }
                start = nums[i];
                pre = nums[i];
            }
        }
        if (start == pre) {
            result.add(start + "");
        }else {
            result.add(start + "->" + pre);
        }
        return result;

    }
}

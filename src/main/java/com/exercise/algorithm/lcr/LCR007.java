package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [ENHANCE]
 * LCR 007. 三数之和
 *
 * @author mihone
 * @since 2025/4/11 9:38
 */
public class LCR007 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left + 1 < nums.length&&nums[left] == nums[left + 1]  ) left++;
                    while (right - 1 >= 0&&nums[right] == nums[right - 1]  ) right--;
                    left++;
                    right--;
                    continue;
                }
                if (sum < 0) {
                    left++;
                }else {
                    right--;
                }
            }


        }
        return res;

    }


}

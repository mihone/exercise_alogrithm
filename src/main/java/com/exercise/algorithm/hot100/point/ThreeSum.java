package com.exercise.algorithm.hot100.point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * @author mihone
 * @since 2025/2/3 14:02
 */
public class ThreeSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right && left < nums.length && right >= 0) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    if (left-1>=0 && right+1<nums.length&&nums[left] == nums[left-1] && nums[right] == nums[right+1]) {
                        left++;
                        right--;
                        continue;
                    }
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }
        return result;

    }
}

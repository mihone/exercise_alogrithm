package com.exercise.algorithm.top150.point;

import java.util.*;

/**
 * 15. 三数之和
 *
 * @author mihone
 * @since 2024/12/4 8:23
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        Set<String> dep = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    if (dep.add(nums[i] + "_" + nums[j] + "_" + nums[k])) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    j++;
                    k--;
                } else if (nums[j] + nums[k] + nums[i]<0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ret;

    }
}

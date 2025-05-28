package com.exercise.algorithm.hot100.v2.point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int total = nums[i] + nums[l] + nums[r];
                if (total == 0) {
                    if (l > i + 1 && r < nums.length - 1 && nums[l] == nums[l - 1] && nums[r] == nums[r + 1]) {
                        l++;
                        r--;
                        continue;
                    }
                    ret.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    continue;
                }

                if (total < 0) {
                    l++;
                } else {
                    r--;
                }

            }
        }
        return ret;

    }
}

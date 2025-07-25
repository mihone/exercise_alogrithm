package com.exercise.algorithm.hot100.v2.trick;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count=1;

        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
                count = 1;
                continue;
            }
            if (nums[i] ==num) {
                count++;
            } else {
                count--;
            }
        }
        return num;

    }
}

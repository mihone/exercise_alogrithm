package com.exercise.algorithm.hot100.v2.trick;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {

        if (nums.length<=1) {
            return 0;
        }

        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int p = nums[0];
        while (p != slow) {
            p = nums[p];
            slow = nums[slow];
        }
        return p;

    }
}

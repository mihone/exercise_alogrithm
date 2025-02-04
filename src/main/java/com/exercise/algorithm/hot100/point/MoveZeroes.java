package com.exercise.algorithm.hot100.point;

public class MoveZeroes    {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length<=1) {
            return;
        }
        int p = 0;
        int index = 0;
        while (p < nums.length) {
            if (nums[p] != 0) {
                int tmp = nums[index];
                nums[index] = nums[p];
                index++;
                nums[p] = tmp;
            }
            p++;
        }

    }

    public static void main(String[] args) {

    }
}

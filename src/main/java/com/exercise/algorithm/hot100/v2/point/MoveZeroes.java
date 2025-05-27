package com.exercise.algorithm.hot100.v2.point;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int index = 0;
        int nextNoZeroIndex = 0;

        while (index<nums.length){
            if (nums[index] != 0) {
                int temp = nums[nextNoZeroIndex];
                nums[nextNoZeroIndex] = nums[index];
                nums[index] = temp;
                nextNoZeroIndex++;
            }
            index++;
        }

    }
}

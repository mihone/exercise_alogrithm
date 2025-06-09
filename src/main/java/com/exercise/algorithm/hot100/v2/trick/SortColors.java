package com.exercise.algorithm.hot100.v2.trick;

public class SortColors {

    public void sortColors(int[] nums) {
        int nextRed = 0;
        int nextBlue = nums.length-1;
        int index = 0;
        while (index <= nextBlue) {
            if (nums[index] == 2) {
                int temp = nums[nextBlue];
                nums[nextBlue] = nums[index];
                nums[index] = temp;
                nextBlue--;

                continue;
            } else if (nums[index] == 0) {
                int temp = nums[nextRed];
                nums[nextRed] = nums[index];
                nums[index] = temp;
                nextRed++;

            }
            index++;
        }
    }
}

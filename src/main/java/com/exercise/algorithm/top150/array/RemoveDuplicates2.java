package com.exercise.algorithm.top150.array;

import java.util.Arrays;

/**
 * 80. 删除有序数组中的重复项 II
 *
 * @author mihone
 * @since 2024/11/20 8:06
 */
public class RemoveDuplicates2 {
    public static void main(String[] args) {
        RemoveDuplicates2 removeDuplicates2 = new RemoveDuplicates2();
        int[] ints = {0,0,1,1,1,2,3,3,4};
        removeDuplicates2.removeDuplicates(ints);
        System.out.println(Arrays.toString(ints));
    }

    public int removeDuplicates(int[] nums) {
        int index = 0;
        int pre = Integer.MIN_VALUE;
        int preCount = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=pre) {
                pre = nums[i];
                nums[index++] = nums[i];
                preCount = 1;
            } else if (preCount < 2) {
                nums[index++] = nums[i];
                preCount++;
            }
        }
        return index;
    }
}

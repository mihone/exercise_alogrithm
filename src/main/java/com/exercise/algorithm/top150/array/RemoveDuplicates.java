package com.exercise.algorithm.top150.array;

import java.util.Arrays;

/**
 * 26. 删除有序数组中的重复项
*  @author mihone
*  @since 2024/11/20 7:58
*/
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates removeElement = new RemoveDuplicates();
        int[] ints = {0,0,1,1,1,2,2,3,3,4};
        removeElement.removeDuplicates(ints);
        System.out.println(Arrays.toString(ints));
    }

    public int removeDuplicates(int[] nums) {
        int index = 0;
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=pre) {
                pre = nums[i];
                nums[index++] = nums[i];
            }
        }
        return index;

    }
}

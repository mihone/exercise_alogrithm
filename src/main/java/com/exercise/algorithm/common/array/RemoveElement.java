package com.exercise.algorithm.common.array;

import java.util.Arrays;

/**
 * 27. 移除元素
 * @author mihone
 * @since 2024/11/19 8:27
 */
public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] r = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement.removeElement(r, 2));
        System.out.println(Arrays.toString(Arrays.stream(r).toArray()));

    }

    public int removeElement(int[] nums, int val) {
        if (nums.length==0) {
            return 0;
        }
        int index = 0;
        int ret = 0;
        while (index < nums.length ) {
            if (nums[index] != val) {
                int temp = nums[index];
                nums[index] = nums[ret];
                nums[ret] = temp;
                ret++;
            }
            index++;
        }
        return ret;
    }
}

package com.exercise.algorithm.top150.array;

import java.util.Arrays;

/**
 * 169. 多数元素
*  @author mihone
*  @since 2024/11/20 8:13
*/
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] ints = {2,2,1,1,1,2,2};
        System.out.println(majorityElement.majorityElement_2(ints));
//        majorityElement.majorityElement()
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    public int majorityElement_2(int[] nums) {
        int ret = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            if (count==0) {
                ret = num;
                count = 1;
            }else if (num == ret) {
                count++;
            }else {
                count--;
            }
        }
        return ret;
    }
}

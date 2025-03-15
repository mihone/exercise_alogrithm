package com.exercise.algorithm.hot100.trick;
/**
 * [REPEAT]
 * 169. 多数元素
*  @author mihone
*  @since 2025/3/15 11:24
*/
public class MajorityElement {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int count = 1;
        int multi = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count==0) {
                count = 1;
                multi = nums[i];
                continue;
            }
            if (nums[i] == multi) {
                count++;
            }else {
                count--;
            }


        }
        return multi;

    }
}

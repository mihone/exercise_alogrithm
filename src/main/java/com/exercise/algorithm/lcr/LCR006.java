package com.exercise.algorithm.lcr;
/**
 * LCR 006. 两数之和 II - 输入有序数组
*  @author mihone
*  @since 2025/3/31 20:50
*/
public class LCR006 {

    public static void main(String[] args) {

    }
    public int[] twoSum(int[] numbers, int target) {

        int l = 0;
        int r = numbers.length-1;
        while (l<r){
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l, r};
            }
            if (sum < target) {
                l++;
            }
            else {
                r--;
            }

        }
        return null;

    }
}

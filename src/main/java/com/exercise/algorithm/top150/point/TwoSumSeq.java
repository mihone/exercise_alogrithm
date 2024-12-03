package com.exercise.algorithm.top150.point;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * @author mihone
 * @since 2024/12/3 8:20
 */
public class TwoSumSeq {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int s = 0;
        int e = numbers.length - 1;
        while (s < e) {
            int sum = numbers[s] + numbers[e];
            if (sum == target) {
                return new int[]{s+1, e+1};
            }
            if (sum < target) {
                s++;
            }
            if (sum > target) {
                e--;
            }
        }
        return null;

    }
}

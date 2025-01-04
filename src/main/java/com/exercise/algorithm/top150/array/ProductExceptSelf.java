package com.exercise.algorithm.top150.array;

import java.util.Arrays;

/**
 *
 * 238. 除自身以外数组的乘积
*  @author mihone
*  @since 2024/11/22 8:28
*/
public class ProductExceptSelf {

    public static void main(String[] args) {

    }
    //1 2 3 4
    //1 1 2 6
    //24 12 4 1

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = left[i] * right[i];
        }
        return ret;
    }
    public int[] productExceptSelf_2(int[] nums) {
        int[] left = new int[nums.length];
        int preRight = 1;
        Arrays.fill(left,1);
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length-1; i >= 0; i--) {
            left[i] = left[i] * preRight;
            preRight = preRight * nums[i];
        }


        return left;
    }
}

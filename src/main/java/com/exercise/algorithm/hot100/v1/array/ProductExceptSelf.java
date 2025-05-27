package com.exercise.algorithm.hot100.v1.array;

/**
 * 238. 除自身以外数组的乘积
 *
 * @author mihone
 * @since 2025/2/3 16:56
 */
public class ProductExceptSelf {

    public static void main(String[] args) {

    }

    //1 1 2 6
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        ret[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        int sum = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            sum *= nums[i+1];
            ret[i] = ret[i] * sum;
        }
        return ret;

    }
}

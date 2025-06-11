package com.exercise.algorithm.hot100.v2.greedy;

import java.util.Arrays;

/**
 * [ENHANCE]
 *
 * @author mihone
 */
public class Jump {

    public int jump(int[] nums) {
        int[] ret = new int[nums.length];
        Arrays.fill(ret, 1000000);
        ret[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= j - i) {
                    ret[i] = Math.min(ret[i], ret[j] + 1);
                }
            }

        }
        return ret[0];


    }
    // 2 5 1 2 2 2 3
    // 2 1

    public int jump2(int[] nums) {
        int step = 0, end = 0, furthest = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果能跳到最后，那么后面都没必要遍历了
            if (end >= nums.length - 1) {
                break;
            }
            furthest = Math.max(furthest, i + nums[i]);  //反复更新 在跳跃范围内的元素能够提供的本次即将跳跃的最远距离
            if (i == end) {  //遍历到上个起跳点能到的最远距离
                end = furthest;  //end更新为：右边界为i时候能提供的最远距离
                step++;  //跳跃次数+1
            }

        }
        return step;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
//        2 5 1 2 2 2 3 转成数组
        int[] nums = {2, 5, 1, 2, 2, 2, 3};
//        int[] nums = {2, 3, 1, 1, 4};
//        System.out.println(jump.jump(nums)); // 输出2
        System.out.println(jump.jump2(nums)); // 输出2
    }
}

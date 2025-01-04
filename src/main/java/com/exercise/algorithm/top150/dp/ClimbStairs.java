package com.exercise.algorithm.top150.dp;

/**
 * 70. 爬楼梯
 *
 * @author mihone
 * @since 2024/12/15 17:21
 */
public class ClimbStairs {

    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= n; i++) {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n2;

    }
}

package com.exercise.algorithm.hot100.dp;
/**
 * 70. 爬楼梯
*  @author mihone
*  @since 2025/3/9 14:42
*/
public class ClimbStairs {
    public int climbStairs(int n) {
        int n1 = 1, n2 = 2;
        if (n ==1) {
            return n1;
        }
        if (n == 2) {
            return n2;
        }
        for (int i = 3; i <= n; i++) {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n2;

    }
}

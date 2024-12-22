package com.exercise.algorithm.top150.math;

/**
 * [REPEAT]
 * 69. x 的平方根
 *
 * @author mihone
 * @since 2024/12/20 22:11
 */
public class MySqrt {


    //本题要舍去小数，意味着返回值的平方一定小于等于x
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid =  (r + l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }



}

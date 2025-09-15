package com.exercise.algorithm.lcr;
/**
 * [ENHANCE]
 * LCR 072. x 的平方根
*  @author mihone
*  @since 2025/9/15 21:27
*/
public class LCR072 {

    public int mySqrt(int x) {
        int ret = 0;
        while ((long) ret * ret <= (long)x) {
            ret++;
        }
        return ret - 1 ;

    }

    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        //二分法找到mid*mid小于等于x的最大的那个
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                //答案只会从这出
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;

    }
}

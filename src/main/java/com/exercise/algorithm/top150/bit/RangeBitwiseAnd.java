package com.exercise.algorithm.top150.bit;
/**
 * [REPEAT]
 * 201. 数字范围按位与
*  @author mihone
*  @since 2025/1/7 21:24
*/
public class RangeBitwiseAnd {
    public static void main(String[] args) {

    }

    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

}

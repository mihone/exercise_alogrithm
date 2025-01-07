package com.exercise.algorithm.top150.bit;
/**
 * [REPEAT]
 * 190. 颠倒二进制位
*  @author mihone
*  @since 2025/1/7 20:59
*/
public class ReverseBits {

    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }


    public static void main(String[] args) {

    }
}

package com.exercise.algorithm.lcr;
/**
 * [REPEAT]
 * LCR 003. 比特位计数
*  @author mihone
*  @since 2025/3/26 21:54
*/
public class LCR003 {

    public static void main(String[] args) {

    }

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }
}

package com.exercise.algorithm.top150.bit;

/**
 * 191. 位1的个数
 *
 * @author mihone
 * @since 2025/1/7 21:05
 */
public class HammingWeight {

    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        while ((n & 1) == 0) {
            n >>= 1;
        }
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {

                count++;
            }
            n >>= 1;
        }
        return count;

    }
}

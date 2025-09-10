package com.exercise.algorithm.lcr;

import java.util.HashSet;
import java.util.Set;

/**
 * [REPEAT]
 * LCR 067. 数组中两个数的最大异或值
*  @author mihone
*  @since 2025/9/9 21:49
*/
public class LCR067 {

    public static void main(String[] args) {

    }
    // 最高位的二进制位编号为 30
    static final int HIGH_BIT = 30;

    /**
     * 自己在纸上写两次循环过程就明白了：从高位开始判断，确定最大值，先判断有没有可以让31位为1的结果，如果有说明答案就是1xxxxxx。 然后判断有没有让31 30位为11的结果，如果有就是11xxxxx 没有就是10xxxxxx 循环31次，
     * 每次循环判断2N次
     * 在具体的实现上，借助a ^ b = c 等价 a ^ c = b的性质，每次循环相当于把所有数字的高i位做一次两数之和
     *
     * */
    public int findMaximumXOR(int[] nums) {
        int x = 0;
       for (int k = HIGH_BIT; k >= 0; --k) {
            Set<Integer> seen = new HashSet<Integer>();
            // 将所有的 pre^k(a_j) 放入哈希表中
            for (int num : nums) {
                // 如果只想保留从最高位开始到第 k 个二进制位为止的部分
                // 只需将其右移 k 位
                seen.add(num >> k);
            }

            // 目前 x 包含从最高位开始到第 k+1 个二进制位为止的部分
            // 我们将 x 的第 k 个二进制位置为 1，即为 x = x*2+1
            int xNext = x * 2 + 1;
            boolean found = false;

            // 枚举 i
            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }

            if (found) {
                x = xNext;
            } else {
                // 如果没有找到满足等式的 a_i 和 a_j，那么 x 的第 k 个二进制位只能为 0
                // 即为 x = x*2
                x = xNext - 1;
            }
        }
        return x;
    }

}

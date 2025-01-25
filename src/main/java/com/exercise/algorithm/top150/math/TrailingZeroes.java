package com.exercise.algorithm.top150.math;

/**
 * [REPEAT]
 * 172. 阶乘后的零
 *
 * @author mihone
 * @since 2024/12/20 21:48
 */
public class TrailingZeroes {


    /**
     * n! 尾零的数量即为 n! 中因子 10 的个数，而 10=2×5，
     * 因此转换成求 n! 中质因子 2 的个数和质因子 5 的个数的较小值。
     * <p>
     * 由于质因子 5 的个数不会大于质因子 2 的个数（具体证明见方法二），
     * 我们可以仅考虑质因子 5 的个数。
     * <p>
     * 而 n! 中质因子 5 的个数等于 [1,n] 的每个数的质因子 5 的个数之和，
     * 我们可以通过遍历 [1,n] 的所有 5 的倍数求出。
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;


    }

    public int trailingZeroes2(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }


    public static void main(String[] args) {
        TrailingZeroes trailingZeroes = new TrailingZeroes();
        System.out.println(trailingZeroes.trailingZeroes(13));

    }
}

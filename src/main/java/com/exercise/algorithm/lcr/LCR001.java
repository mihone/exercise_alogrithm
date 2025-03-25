package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

/**
 * [REPEAT]
 * LCR 001. 两数相除
 *
 * @author mihone
 * @since 2025/3/25 20:54
 */
public class LCR001 {
    public static void main(String[] args) {
        LCR001 lcr001 = new LCR001();
//        lcr001.divide(10, 3);
        lcr001.divide(-2147483648, 2147483647);
        int minValue = Integer.MIN_VALUE;
        System.out.println(Integer.MAX_VALUE/Integer.MIN_VALUE);
        System.out.println(-2/Integer.MAX_VALUE);
        System.out.println(minValue );
        System.out.println(minValue - 2);
    }

    public int divide(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (a == 0) {
            return 0;
        }

        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) {
                return Integer.MAX_VALUE;
            }

        }
        if (b == Integer.MAX_VALUE) {
            if (a == Integer.MAX_VALUE) {
                return 1;
            }
            else if (a == Integer.MIN_VALUE) {
                return -1;
            }else {
                return 0;
            }
        }
        if (b == Integer.MIN_VALUE) {
            if (a == Integer.MIN_VALUE) {
                return 1;
            } else {
                return 0;
            }
        }
        int plus = 0;
        if (a > 0) {
            plus++;
            a = -a;
        }
        if (b > 0) {
            plus++;
            b = -b;
        }
        List<Integer> candidates = new ArrayList<Integer>();
        candidates.add(b);
        int index = 0;
        // 注意溢出
        while (candidates.get(index) >= a - candidates.get(index)) {
            candidates.add(candidates.get(index) + candidates.get(index));
            ++index;
        }
        int ans = 0;
        for (int i = candidates.size() - 1; i >= 0; --i) {
            if (candidates.get(i) >= a) {
                ans += 1 << i;
                a -= candidates.get(i);
            }
        }

        if (plus == 1) {
            return -ans;
        } else {
            return ans;
        }

    }
}

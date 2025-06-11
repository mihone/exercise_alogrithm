package com.exercise.algorithm.hot100.v2.dp;

import java.util.Arrays;

public class NumSquares {

    public int numSquares(int n) {
        int[] ret = new int[n + 1];
        Arrays.fill(ret, n);
        ret[0] = 0;
        ret[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                ret[i] = Math.min(ret[i], ret[i - j * j] + 1);
            }
        }

        return ret[n];

    }
}

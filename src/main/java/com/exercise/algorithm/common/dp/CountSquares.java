package com.exercise.algorithm.common.dp;
/**
 * [REPEAT]
 * 1277. 统计全为 1 的正方形子矩阵
*  @author mihone
*  @since 2025/1/25 12:45
*/
public class CountSquares {

    public static void main(String[] args) {

    }

    public int  countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] f = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    f[i][j] = matrix[i][j];
                }
                else if (matrix[i][j] == 0) {
                    f[i][j] = 0;
                }
                else {
                    f[i][j] = Math.min(Math.min(f[i][j - 1], f[i - 1][j]), f[i - 1][j - 1]) + 1;
                }
                ans += f[i][j];
            }
        }
        return ans;
    }

}

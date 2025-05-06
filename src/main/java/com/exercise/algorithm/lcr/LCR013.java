package com.exercise.algorithm.lcr;

import java.util.*;

/**
 * [REPEAT]
 * LCR 013. 二维区域和检索 - 矩阵不可变
*  @author mihone
*  @since 2025/5/4 10:02
*/
public class LCR013 {



    static class NumMatrix {
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            if (m > 0) {
                int n = matrix[0].length;
                sums = new int[m + 1][n + 1];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
        }
    }


    static class NumMatrix2 {

        int[][] sums;

        public NumMatrix2(int[][] matrix) {
            int m = matrix.length;
            if (m > 0) {
                int n = matrix[0].length;
                sums = new int[m][n];
                sums[0][0] = matrix[0][0];
                for (int i = 1; i < m; i++) {
                    sums[i][0] = sums[i - 1][0] + matrix[i][0];
                }
                for (int i = 1; i < n; i++) {
                    sums[0][i] = sums[0][i - 1] + matrix[0][i];
                }



                for (int i = 1; i < m; i++) {
                    for (int j = 1; j < n; j++) {
                        sums[i][j] = sums[i-1][j ] + sums[i][j-1] - sums[i-1][j-1] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2][col2] - (row1-1>=0?sums[row1-1][col2]:0) - (col1-1>=0?sums[row2][col1-1]:0) + (row1-1>=0&&col1-1>=0?sums[row1-1][col1-1]:0);

        }

    }

}

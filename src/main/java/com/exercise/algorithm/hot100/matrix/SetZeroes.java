package com.exercise.algorithm.hot100.matrix;

import java.util.Arrays;

/**
 * 73. 矩阵置零
*  @author mihone
*  @since 2025/2/3 17:06
*/
public class SetZeroes {
    public static void main(String[] args) {

    }
    public void setZeroes(int[][] matrix) {
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                row = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                col = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        if (row) {
            Arrays.fill(matrix[0], 0);
        }
        if (col) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }

    }
}

package com.exercise.algorithm.top150.matrix;

/**
 * 48. 旋转图像
 *
 * @author mihone
 * @since 2024/12/7 17:21
 */
public class Rotate {

    public static void main(String[] args) {

    }


    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }


        for (int i = 0; i < n; i++) {
            int s = 0;
            int e = n - 1;
            while (s < e) {
                int temp = matrix[s][i];
                matrix[s][i] = matrix[e][i];
                matrix[e][i] = temp;
                s++;
                e--;
            }
        }

    }
}

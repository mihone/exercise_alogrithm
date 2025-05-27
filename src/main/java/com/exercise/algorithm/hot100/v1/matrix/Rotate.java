package com.exercise.algorithm.hot100.v1.matrix;

/**
 * 48. 旋转图像
 *
 * @author mihone
 * @since 2025/2/3 17:36
 */
public class Rotate {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = temp;

            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0; int right = n - 1;
            while (left < right) {
                int temp = matrix[left][i];
                matrix[left][i] = matrix[right][i];
                matrix[right][i] = temp;
                left++;
                right--;
            }

        }

    }
}

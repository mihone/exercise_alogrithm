package com.exercise.algorithm.hot100.v2.matrix;

public class Rotate {

    public void rotate(int[][] matrix) {

        int n = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] =matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = temp;

            }
        }

        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = n-1;
            while (l<r){
                int temp =matrix[l][i];
                matrix[l][i] = matrix[r][i];
                matrix[r][i] = temp;
                l++;
                r--;
            }
        }

    }
}

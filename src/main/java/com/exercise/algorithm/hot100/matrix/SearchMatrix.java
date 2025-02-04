package com.exercise.algorithm.hot100.matrix;
/**
 * 240. 搜索二维矩阵 II
*  @author mihone
*  @since 2025/2/3 17:34
*/
public class SearchMatrix {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] < target) {
                x++;
            }else {
                y--;
            }

        }
        return false;

    }
}

package com.exercise.algorithm.hot100.v1.binary;

/**
 * [ENHANCE]
 * 74. 搜索二维矩阵
 *
 * @author mihone
 * @since 2025/3/5 21:51
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int row = left >= matrix.length ? matrix.length - 1 : left-1;
        if (row-1<0) {
            return false;
        }

        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
}

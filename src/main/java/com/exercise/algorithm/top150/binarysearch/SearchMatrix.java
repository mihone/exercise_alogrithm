package com.exercise.algorithm.top150.binarysearch;

/**
 * 74. 搜索二维矩阵
 *
 * @author mihone
 * @since 2025/1/18 11:48
 */
public class SearchMatrix {

    public static void main(String[] args) {

    }
//@6-1.19
    public boolean searchMatrix0(int[][] matrix, int target) {
        int r = matrix.length - 1;
        int c = 0;
        while (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                r--;
            } else {
                c++;
            }

        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        int rr = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (matrix[m][0] == target) {
                return true;
            }
            else if (matrix[m][0] > target) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }

        }
        rr = l - 1;
        if (rr<0) {
            return false;
        }
        l = 0;
        r = matrix[0].length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (matrix[rr][m] == target) {
                return true;
            }
            else if (matrix[rr][m] > target) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return false;

    }

}

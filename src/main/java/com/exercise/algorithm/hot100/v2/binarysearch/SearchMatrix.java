package com.exercise.algorithm.hot100.v2.binarysearch;

public class SearchMatrix {
    public static void main(String[] args) {

    }


    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }

        int left = 0;
        int right = matrix.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left <= 0 ) {
            return false;
        }

        int row = left-1;

        left = 0;
        right = matrix[row].length-1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;


    }
}

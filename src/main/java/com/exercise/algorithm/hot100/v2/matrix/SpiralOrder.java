package com.exercise.algorithm.hot100.v2.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        int[][] dest = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> ret = new ArrayList<>();
        int total = matrix.length * matrix[0].length;
        int i = 0, j = 0;
        int index = 0;
        while (ret.size() < total) {
            int[] d = dest[index % 4];
            while (i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length && !visited[i][j]) {
                ret.add(matrix[i][j]);
                visited[i][j] = true;
                i += d[0];
                j += d[1];
            }
            i-= d[0];
            j-= d[1];
            index++;
            d = dest[index % 4];
            i += d[0];
            j += d[1];
        }

        return ret;

    }

}

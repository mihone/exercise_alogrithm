package com.exercise.algorithm.hot100.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * [ENHANCE]
 * 54. 螺旋矩阵
*  @author mihone
*  @since 2025/2/3 17:44
*/
public class SpiralOrder {

    public static void main(String[] args) {

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length<=0) {
            return null;
        }
        List<Integer> ret = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] dest = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int total = matrix.length * matrix[0].length;
        int destCount = 0;
        int i = 0;
        int j = 0;
        while (ret.size() < total) {
            int[] d = dest[destCount % 4];
            while (i < matrix.length && j < matrix[0].length && i>=0 && j>=0 && !visited[i][j]) {
                ret.add(matrix[i][j]);
                visited[i][j] = true;
                i += d[0];
                j += d[1];
            }
            destCount++;
            //超出了，先回退
            i -= d[0];
            j -= d[1];
            //进入下一个未遍历的
            i += dest[destCount % 4][0];
            j += dest[destCount % 4][1];
        }
        return ret;

    }
}

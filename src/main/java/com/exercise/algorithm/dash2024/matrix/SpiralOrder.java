package com.exercise.algorithm.dash2024.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * @author mihone
 * @since 2025/3/17 21:34
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        int[][] dest = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = rows * cols;
        boolean[][] visited = new boolean[rows][cols];
        int i = 0;
        int j = 0;
        int index = 0;
        while (ret.size() < count) {
            int dIndex = index % 4;
            int[] d = dest[dIndex];

            while (i >= 0 && j >= 0 && i < rows && j < cols && !visited[i][j]) {
                visited[i][j] = true;
                ret.add(matrix[i][j]);
                i = i + d[0];
                j = j + d[1];
            }
            i = i - d[0];
            j = j - d[1];

            index++;
            i = i + dest[index%4][0];
            j = j + dest[index%4][1];
        }
        return ret;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        spiralOrder.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}

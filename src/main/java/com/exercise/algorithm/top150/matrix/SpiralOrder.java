package com.exercise.algorithm.top150.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * @author mihone
 * @since 2024/12/7 17:07
 */
public class SpiralOrder {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return Collections.emptyList();
        }

        int max = matrix.length * matrix[0].length;
        int[][] move = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int moveIndex = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int count = 0;
        int i = 0;
        int j = 0;
        List<Integer> ret = new ArrayList<>();
        while (true) {
            ret.add(matrix[i][j]);
            visited[i][j] = true;
            count++;
            if (count >= max) {
                break;
            }
            int[] m = move[moveIndex % 4];
            if (i + m[0] >= matrix.length || i + m[0] < 0
                    || j + m[1] >= matrix[0].length || j + m[1] < 0
                    || visited[i + m[0]][j + m[1]]) {
                moveIndex++;
                m = move[moveIndex % 4];

            }
            i += m[0];
            j += m[1];

        }
        return ret;

    }

}

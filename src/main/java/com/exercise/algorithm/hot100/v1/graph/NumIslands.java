package com.exercise.algorithm.hot100.v1.graph;
/**
 * 200. 岛屿数量
*  @author mihone
*  @since 2025/2/9 14:56
*/
public class NumIslands {

    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        if (grid ==null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    internal(grid, i, j);
                    count++;
                }

            }
        }
        return count;

    }

    public void internal(char[][] grid, int i, int j) {
        if (i<0||j<0||i>=grid.length || j>=grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        internal(grid, i-1, j);
        internal(grid, i+1, j);
        internal(grid, i, j-1);
        internal(grid, i, j+1);
    }
}

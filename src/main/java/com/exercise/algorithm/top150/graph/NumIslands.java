package com.exercise.algorithm.top150.graph;

/**
 * 200. 岛屿数量
 *
 * @author mihone
 * @since 2025/1/4 16:23
 */
public class NumIslands {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {

        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ret++;
                    numIslands(grid, i, j);
                }

            }
        }
        return ret;

    }

    public void numIslands(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';

        numIslands(grid, i - 1, j);
        numIslands(grid, i + 1, j);
        numIslands(grid, i, j - 1);
        numIslands(grid, i, j + 1);

    }


}

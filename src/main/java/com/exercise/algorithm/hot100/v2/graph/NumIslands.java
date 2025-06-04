package com.exercise.algorithm.hot100.v2.graph;

public class NumIslands {

    public int numIslands(char[][] grid) {

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslandsInternal(grid, i, j);
                    ans++;
                }

            }
        }
        return ans;

    }

    public void numIslandsInternal(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        numIslandsInternal(grid, i - 1, j);
        numIslandsInternal(grid, i + 1, j);
        numIslandsInternal(grid, i, j - 1);
        numIslandsInternal(grid, i, j + 1);

    }
}

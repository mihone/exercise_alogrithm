package com.exercise.algorithm.hot100.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * [REPEAT]
 * 994. 腐烂的橘子
 *
 * @author mihone
 * @since 2025/2/9 15:01
 */
public class OrangesRotting {

    public static void main(String[] args) {
        OrangesRotting orangesRotting = new OrangesRotting();
        int i = orangesRotting.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 1}, {0, 1, 2}});

    }

    public int orangesRotting(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    //代表0分钟的坏橘子
                    grid[i][j] = 0;
                    internal(grid,  i + 1, j, 1);
                    internal(grid,  i - 1, j, 1);
                    internal(grid,  i, j + 1, 1);
                    internal(grid,  i, j - 1, 1);
                }

            }
        }
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                if (grid[i][j] < 0) {
                    ret = Math.max(ret, Math.abs(grid[i][j]));
                }
            }
        }
        return ret;

    }

    private void internal(int[][] grid, int i, int j, int min) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 2 || grid[i][j] == 0) {
            return;
        }
        if (grid[i][j] < 0 && min >= -grid[i][j]) {
            return;
        }
        grid[i][j] = grid[i][j] < 0 ? Math.max(grid[i][j], -min) : -min;
        internal(grid,  i + 1, j, min + 1);
        internal(grid,  i - 1, j, min + 1);
        internal(grid,  i, j + 1, min + 1);
        internal(grid,  i, j - 1, min + 1);

    }

    //bfs

    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRottingBfs(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        Map<Integer, Integer> depth = new HashMap<Integer, Integer>();
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        for (int[] row: grid) {
            for (int v: row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

}

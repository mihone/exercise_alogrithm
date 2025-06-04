package com.exercise.algorithm.hot100.v2.graph;

import java.util.LinkedList;
/**
 * [ENHANCE]
*  @author mihone
*  @since 2025/6/4 19:42
*/
public class OrangesRotting {


    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();

        int oneCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    oneCount++;
                }
            }
        }
        int count = queue.size();
        //注意一开始没有橘子，和一开始只有正常橘子的情况
        if (count == 0) {
            return oneCount==0?0:-1;
        }
        int min = 0;
        int[][] dest = new int[][]{
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        while (!queue.isEmpty()) {
            int partCount = 0;
            for (int k = 0; k < count; k++) {
                int[] poll = queue.poll();
                int i = poll[0];
                int j = poll[1];
                for (int[] ints : dest) {
                    int newI = i + ints[0];
                    int newJ = j + ints[1];
                    if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == 1) {
                        grid[newI][newJ] = 2;
                        queue.offer(new int[]{newI, newJ});
                        partCount++;
                    }
                }
            }
            count = partCount;
            min++;
        }
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return -1;
                }
            }
        }
        return min-1;

    }
}

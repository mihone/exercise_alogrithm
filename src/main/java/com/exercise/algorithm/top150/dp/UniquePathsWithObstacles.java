package com.exercise.algorithm.top150.dp;

/**
 * [ENHANCE]
 * 63. 不同路径 II
 *
 * @author mihone
 * @since 2025/1/19 11:39
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        uniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}});
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null) {
            return 0;
        }
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else {
                        if (i - 1 >= 0) {
                            dp[i][j] += dp[i - 1][j];
                        }
                        if (j - 1 >= 0) {
                            dp[i][j] += dp[i][j - 1];
                        }
                    }
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];

    }
}

package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCR 100. 三角形最小路径和
 *
 * @author mihone
 * @since 2025/10/7 10:11
 */
public class LCR100 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        LCR100 lcr100 = new LCR100();
        System.out.println(lcr100.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }


        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> line = triangle.get(i);
            for (int j = 1; j < line.size() - 1; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j], dp[i-1][j-1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[triangle.size() - 1].length; i++) {
            min = Math.min(min, dp[triangle.size() - 1][i]);
        }
        return min;


    }
}

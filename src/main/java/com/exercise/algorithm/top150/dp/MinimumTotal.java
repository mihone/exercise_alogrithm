package com.exercise.algorithm.top150.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
*  @author mihone
*  @since 2025/1/21 20:50
*/
public class MinimumTotal {

    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<List<Integer>>();
        dp.add(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> line = triangle.get(i);
            dp.add(new ArrayList<>());
            for (int j = 0; j < line.size(); j++) {
                int min = Integer.MAX_VALUE;
                if (j - 1 < 0) {
                    min = Math.min(min, dp.get(i-1).get(j));
                } else if (j >= dp.get(i - 1).size()) {
                    min = Math.min(min, dp.get(i-1).get(j-1));
                }else {
                    min = Math.min(Math.min(min, dp.get(i-1).get(j-1)), dp.get(i-1).get(j));
                }
                dp.get(i).add(line.get(j) + min);
            }
        }
        int ret = Integer.MAX_VALUE;
        List<Integer> integers = dp.get(dp.size() - 1);
        for (Integer integer : integers) {
            ret = Math.min(ret, integer);
        }
        return ret;
    }
}

package com.exercise.algorithm.top150.zone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
*  @author mihone
*  @since 2024/12/9 21:32
*/
public class FindMinArrowShots {
    public static void main(String[] args) {

    }
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < points.length; ++i) {
            int L = points[i][0], R = points[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.min(merged.get(merged.size() - 1)[1], R);
                merged.get(merged.size() - 1)[0] = Math.max(merged.get(merged.size() - 1)[0], L);
            }
        }
        return merged.size();
    }
}

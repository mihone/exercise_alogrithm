package com.exercise.algorithm.top150.zone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 57. 插入区间
*  @author mihone
*  @since 2024/12/9 21:07
*/
public class Insert {
    public static void main(String[] args) {

    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int[][] ints = new int[intervals.length+1][];
        for (int i = 0; i < intervals.length; i++) {
            ints[i] = intervals[i];
        }
        ints[intervals.length] = newInterval;
        Arrays.sort(ints, (interval1, interval2) -> interval1[0] - interval2[0]);
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < ints.length; ++i) {
            int L = ints[i][0], R = ints[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

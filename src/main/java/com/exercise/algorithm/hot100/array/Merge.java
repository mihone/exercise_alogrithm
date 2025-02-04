package com.exercise.algorithm.hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
*  @author mihone
*  @since 2025/2/3 16:49
*/
public class Merge {
    public static void main(String[] args) {

    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> r = new ArrayList<>();
        r.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] > r.get(r.size() - 1)[1]) {
                r.add(interval);
            }else {
                r.get(r.size() - 1)[1] = Math.max(r.get(r.size() - 1)[1], interval[1]);
            }
        }
        return r.toArray(new int[r.size()][]);

    }
}

package com.exercise.algorithm.hot100.v2.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {


    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ret = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                ret.add(intervals[i]);
                continue;
            }
            int[] pre = ret.get(ret.size() - 1);
            if (pre[1]<intervals[i][0]) {
                ret.add(intervals[i]);
            }else {
                pre[1] = Math.max(pre[1], intervals[i][1]);
            }
        }


        return ret.toArray(new int[0][]);

    }
}

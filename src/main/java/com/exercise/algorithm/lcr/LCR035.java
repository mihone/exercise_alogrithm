package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [ENHANCE]
 * LCR 035. 最小时间差
*  @author mihone
*  @since 2025/5/13 21:01
*/
public class LCR035 {

    public int findMinDifference(List<String> timePoints) {
        List<Integer> mins = new ArrayList<Integer>();

        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            mins.add(Integer.parseInt(split[0])*60+Integer.parseInt(split[1]));
            mins.add((Integer.parseInt(split[0])+24)*60+Integer.parseInt(split[1]));
        }
        Collections.sort(mins);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < mins.size(); i++) {
            min = Math.min(min, mins.get(i)-mins.get(i-1));
        }
        return min;

    }
}

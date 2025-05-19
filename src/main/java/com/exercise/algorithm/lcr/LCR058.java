package com.exercise.algorithm.lcr;

import java.util.TreeSet;

/**
 * [REPEAT]
 * LCR 058. 我的日程安排表 I
 *
 * @author mihone
 * @since 2025/5/19 22:34
 */
public class LCR058 {

    static class MyCalendar {
        TreeSet<int[]> booked;

        public MyCalendar() {
            booked = new TreeSet<int[]>((a, b) -> a[0] - b[0]);
        }

        public boolean book(int start, int end) {
            if (booked.isEmpty()) {
                booked.add(new int[]{start, end});
                return true;
            }
            int[] tmp = {end, 0};
            int[] arr = booked.ceiling(tmp);
            if (arr != null) {
                int[] pre = booked.lower(arr);
                if (pre == null || pre[1] <= start) {
                    booked.add(new int[]{start, end});
                    return true;
                }
            } else {
                int[] last = booked.last();
                if (last[1] <= start) {
                    booked.add(new int[]{start, end});
                    return true;
                }

            }
            return false;
        }
    }
}

package com.exercise.algorithm.hot100.v2.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanFinish {


    boolean flag = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> integers = map.get(prerequisite[0]);
            if (integers == null) {
                integers = new ArrayList<>();
                map.put(prerequisite[0], integers);
            }
            integers.add(prerequisite[1]);
        }

        int[] courses = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!flag) {
                return false;
            }
            if (courses[i] == 0) {
                canFinishInternal(courses, i, map);
            }
        }


        return flag;

    }


    public void canFinishInternal(int[] numCourses, int cur, Map<Integer, List<Integer>> map) {
        if (!flag) {
            return;
        }
        if (numCourses[cur] == 1) {
            flag = false;
            return;
        }
        numCourses[cur] = 1;
        List<Integer> pres = map.get(cur);
        if (pres != null && !pres.isEmpty()) {

            for (Integer pre : pres) {
                if (numCourses[pre] == 1) {
                    flag = false;
                    return;
                }
                if (numCourses[pre] == 0) {
                    canFinishInternal(numCourses, pre, map);
                }
            }

        }
        numCourses[cur] = 2;
    }
}

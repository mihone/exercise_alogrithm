package com.exercise.algorithm.hot100.v1.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 207. 课程表
*  @author mihone
*  @since 2025/2/9 16:25
*/
public class CanFinish {

    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> integers = map.get(prerequisites[i][0]);
            if (integers == null) {
                integers = new ArrayList<>();
                map.put(prerequisites[i][0], integers);
            }
            integers.add(prerequisites[i][1]);
        }
        int[] courses = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean dfs = dfs(i, courses,map);
            if (!dfs) {
                return false;
            }
        }
        return true;

    }

    public boolean dfs(int numCourses, int[] courses, Map<Integer, List<Integer>> map) {
        if (courses[numCourses] == 1) {
            return false;
        }
        if (courses[numCourses] == 2) {
            return true;
        }
        courses[numCourses] = 1;
        List<Integer> integers = map.get(numCourses);
        if (integers != null) {
            for (Integer p : integers) {
                boolean dfs = dfs(p, courses, map);
                if (!dfs) {
                    return false;
                }
            }

        }
        courses[numCourses] = 2;
        return true;
    }
}

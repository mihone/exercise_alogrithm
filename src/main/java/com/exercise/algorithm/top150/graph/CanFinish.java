package com.exercise.algorithm.top150.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 207. 课程表
 *
 * @author mihone
 * @since 2025/1/4 19:59
 */
public class CanFinish {

    public static void main(String[] args) {

    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> preMap = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            List<Integer> integers = preMap.get(prerequisite[0]);
            if (integers == null) {
                integers = new ArrayList<>();
                preMap.put(prerequisite[0], integers);
            }
            integers.add(prerequisite[1]);
        }

        // 未学习0 在途1 学完2
        int[] courses = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean dfs = dfs(courses, i, preMap);
            if (!dfs) {
                return false;
            }
        }
        return true;

    }

    private boolean dfs(int[] courses, int c, Map<Integer, List<Integer>> preMap) {
        if (courses[c] == 1) {
            return false;
        }
        if (courses[c] == 2) {
            return true;
        }
        courses[c] = 1;
        List<Integer> integers = preMap.get(c);
        if (integers != null && !integers.isEmpty()) {
            for (Integer integer : integers) {
                boolean dfs = dfs(courses, integer, preMap);
                if (!dfs) {
                    return false;
                }
            }

        }
        courses[c] = 2;

        return true;
    }
}

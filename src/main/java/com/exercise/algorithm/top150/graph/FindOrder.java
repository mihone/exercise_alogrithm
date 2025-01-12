package com.exercise.algorithm.top150.graph;

import java.util.*;

/**
 * 210. 课程表 II
 *
 * @author mihone
 * @since 2025/1/11 10:55
 */
public class FindOrder {

    public static void main(String[] args) {

    }

    int count = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int[] p : prerequisites) {
            List<Integer> l = courseMap.get(p[0]);
            if (l == null) {
                l = new ArrayList<Integer>();
                courseMap.put(p[0], l);
            }
            l.add(p[1]);
        }
        int[] ret = new int[numCourses];
        //0 未学习 1学习中 2学完了
        int[] process = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean dfs = dfs(i, courseMap, process, ret);
            if (!dfs) {
                return new int[0];
            }

        }
        return ret;

    }

    public boolean dfs(int course, Map<Integer, List<Integer>> courseMap,
                       int[] process, int[] ret) {
        if (process[course] == 2) {
            return true;
        }
        if (process[course] == 1) {
            return false;
        }
        process[course] = 1;
        List<Integer> preList = courseMap.get(course);
        if (preList != null && !preList.isEmpty()) {

            for (Integer i : preList) {
                boolean dfs = dfs(i, courseMap, process, ret);
                if (!dfs) {
                    return false;
                }
            }

        }
        process[course] = 2;
        ret[count++] = course;
        return true;
    }
}

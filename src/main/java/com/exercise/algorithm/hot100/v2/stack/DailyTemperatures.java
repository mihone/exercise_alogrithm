package com.exercise.algorithm.hot100.v2.stack;

import java.util.LinkedList;

public class DailyTemperatures {


    public int[] dailyTemperatures(int[] temperatures) {

        LinkedList<Integer> stack = new LinkedList<>();
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() &&temperatures[stack.peek()]<temperatures[i]) {
                Integer pop = stack.pop();
                ret[pop] = i - pop;

            }
            stack.push(i);
        }
        return ret;

    }
}

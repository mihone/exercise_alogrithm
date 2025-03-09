package com.exercise.algorithm.hot100.stack;

import java.util.LinkedList;

/**
 * 739. 每日温度
*  @author mihone
*  @since 2025/3/9 12:28
*/
public class DailyTemperatures {

    public static void main(String[] args) {

    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer pop = stack.pop();
                result[pop] = i-pop;
            }
            stack.push(i);

        }
        return result;


    }
}

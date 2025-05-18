package com.exercise.algorithm.lcr;

import java.util.LinkedList;

/**
 * [ENHANCE]
 * LCR 038. 每日温度
 *
 * @author mihone
 * @since 2025/5/18 14:03
 */
public class LCR038 {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer pop = stack.pop();
                result[pop] = i-pop;
            }
            stack.push(i);

        }
        return result;

    }
}

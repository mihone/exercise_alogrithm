package com.exercise.algorithm.lcr;

import java.util.LinkedList;

/**
 * [REPEAT]
 * LCR 037. 行星碰撞
*  @author mihone
*  @since 2025/5/13 21:37
*/
public class LCR037 {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length <=1) {
            return asteroids;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        for (int asteroid : asteroids) {
            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
                continue;
            }
            if (asteroid<0) {
                boolean alive = true;
                while (!stack.isEmpty() && stack.peek()>0) {
                    Integer pop = stack.pop();
                    if (pop > -asteroid) {
                        stack.push(pop);
                        alive = false;
                        break;
                    } else if (pop == -asteroid) {
                        alive = false;
                        break;
                    }
                }
                if (alive) {
                    stack.push(asteroid);
                }
            } else {
                stack.push(asteroid);

            }
        }
        int[] result = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()){
            result[i] = stack.pop();
            i--;
        }
        return result;

    }
}

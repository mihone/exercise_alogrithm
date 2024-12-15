package com.exercise.algorithm.top150.stack;

import java.util.LinkedList;

/**
 * 155. 最小栈
*  @author mihone
*  @since 2024/12/11 21:29
*/
public class MinStack {

    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> min = new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (!min.isEmpty()) {
            if (min.peek()>val) {
                min.push(val);
            }else {
                min.push(min.peek());
            }
        }else {
            min.push(val);
        }


    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();

        }
        if (!min.isEmpty()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek() == null ? 0 : stack.peek();

    }

    public int getMin() {
        if (!min.isEmpty()) {
            return min.peek();
        }
        return 0;
    }
}

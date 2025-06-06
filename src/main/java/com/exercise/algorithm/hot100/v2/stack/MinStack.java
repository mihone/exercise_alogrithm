package com.exercise.algorithm.hot100.v2.stack;

import java.util.LinkedList;

public class MinStack {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> min = new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (min.isEmpty()) {
            min.push(val);
        }else {
            if (min.peek()>val) {
                min.push(val);
            } else {
                min.push(min.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        min.pop();

    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek();

    }

    public int getMin() {
        if (min.isEmpty()) {
            return 0;
        }
        return min.peek();

    }
}

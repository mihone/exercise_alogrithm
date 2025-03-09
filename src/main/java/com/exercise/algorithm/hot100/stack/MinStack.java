package com.exercise.algorithm.hot100.stack;

import java.util.LinkedList;

/**
 * 155. 最小栈
*  @author mihone
*  @since 2025/3/9 11:57
*/
public class MinStack {
    LinkedList<Integer> min = new LinkedList<>();
    LinkedList<Integer> stack = new LinkedList<>();
    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        Integer peek = min.peek();
        if (peek == null) {
            min.push(val);
            return;
        }
        if (peek>val) {
            min.push(val);
        }else {
            min.push(peek);
        }

    }

    public void pop() {
        stack.pop();
        min.pop();

    }

    public int top() {
        return stack.peek() == null ? -1 : stack.peek();


    }

    public int getMin() {
        return min.peek() == null ? 0 : min.peek();

    }
}

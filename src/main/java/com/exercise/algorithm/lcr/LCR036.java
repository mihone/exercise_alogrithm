package com.exercise.algorithm.lcr;

import java.util.LinkedList;

/**
 * LCR 036. 逆波兰表达式求值
*  @author mihone
*  @since 2025/5/13 21:18
*/
public class LCR036 {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {

        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int sum = 0;
                sum+=stack.pop();
                sum+=stack.pop();
                stack.push(sum);

            } else if ("-".equals(token)) {
                Integer d = stack.pop();
                stack.push(stack.pop()-d);

            } else if ("*".equals(token)) {
                int ret = stack.pop();
                ret = ret*stack.pop();
                stack.push(ret);

            } else if ("/".equals(token)) {
                Integer d = stack.pop();
                stack.push(stack.pop()/d);

            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();

    }
}

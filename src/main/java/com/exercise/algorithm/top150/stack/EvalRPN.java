package com.exercise.algorithm.top150.stack;

import java.util.LinkedList;

/**
 * 150. 逆波兰表达式求值
 *
 * @author mihone
 * @since 2024/12/11 21:34
 */
public class EvalRPN {
    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        System.out.println(evalRPN.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> list = new LinkedList<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {

                Integer p1 = list.pop();
                Integer p2 = list.pop();

                if ("+".equals(token)) {
                    int newP = p2 + p1;
                    list.push(newP);
                } else if ("-".equals(token)) {
                    int newP = p2 - p1;
                    list.push(newP);
                } else if ("*".equals(token)) {
                    int newP = p2 * p1;
                    list.push(newP);
                } else {
                    int newP = p2 / p1;
                    list.push(newP);
                }
            } else {
                list.push(Integer.parseInt(token));
            }
        }
        return list.pop();

    }
}

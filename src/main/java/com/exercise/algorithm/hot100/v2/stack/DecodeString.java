package com.exercise.algorithm.hot100.v2.stack;

import jdk.nashorn.internal.ir.IfNode;

import java.util.LinkedList;
import java.util.List;

public class DecodeString {


    //2[abc]3[cd]ef
    //abcabccdcdcdef
    //3[a2[c]]
    public String decodeString(String s) {
        int index = 0;
        LinkedList<String> stack = new LinkedList<>();
        while (index < s.length()) {
            StringBuilder dig = new StringBuilder();
            while (Character.isDigit(s.charAt(index))) {
                dig.append(s.charAt(index));
                index++;
            }
            if (dig.length() > 0) {
                stack.push(dig.toString());
            }
            if (']' != s.charAt(index)) {
                stack.push(String.valueOf(s.charAt(index)));
                index++;
                continue;
            }
            StringBuilder part = new StringBuilder();
            while (!stack.isEmpty()&&!stack.peek().equals("[")){
                part.insert(0, stack.pop());
            }
            //去掉[
            stack.pop();
            //取数字
            int digStr = Integer.parseInt(stack.pop());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digStr; i++) {
                sb.append(part);
            }
            stack.push(sb.toString());
            index++;
        }

        StringBuilder ret = new StringBuilder();
        while (!stack.isEmpty()){
            ret.insert(0, stack.pop());
        }
        return ret.toString();

    }
}

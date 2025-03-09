package com.exercise.algorithm.hot100.stack;

import java.util.LinkedList;

/**
 * [ENHANCE]
 * 394. 字符串解码
*  @author mihone
*  @since 2025/3/9 12:02
*/
public class DecodeString {

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a2[c]]"));

    }
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (']' != c) {
                stack.push(String.valueOf(c));
                index++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty() && !stack.peek().equals("[")) {
                sb.insert(0, stack.pop());
            }
            //删掉 [
            stack.pop();
            StringBuilder num = new StringBuilder();
            while (!stack.isEmpty() && !Character.isDigit(stack.peek().charAt(0))) {
                num.insert(0, stack.pop());
            }
            String dig = num.toString();
            int i = Integer.parseInt(dig);
            String part = sb.toString();
            for (int i1 = 0; i1 < i-1; i1++) {
                sb.append(part);
            }
            stack.push(sb.toString());
            index++;
        }
        StringBuilder sb = new StringBuilder();
        while (stack.isEmpty()) {
            String pop = stack.pop();
            sb.insert(0, pop);
        }
        return sb.toString();

    }
}

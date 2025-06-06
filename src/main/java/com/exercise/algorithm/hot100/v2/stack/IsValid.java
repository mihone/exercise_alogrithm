package com.exercise.algorithm.hot100.v2.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IsValid {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();

        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('{' == c || '(' == c || '[' == c) {
                stack.push(c);
                continue;
            }
            Character c1 = map.get(c);
            Character peek = stack.peek();
            if (c1 == peek) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();

    }
}

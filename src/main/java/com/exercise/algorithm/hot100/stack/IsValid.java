package com.exercise.algorithm.hot100.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
*  @author mihone
*  @since 2025/3/9 11:15
*/
public class IsValid {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.values().contains(c)) {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character c1 = map.get(c);
                Character c2 = stack.pop();
                if (c1 != c2) {
                    return false;
                }
            }
        }
        return stack.isEmpty();


    }
}

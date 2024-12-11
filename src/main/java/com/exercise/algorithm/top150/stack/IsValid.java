package com.exercise.algorithm.top150.stack;

import java.util.*;

/**
 * 452. 用最少数量的箭引爆气球
*  @author mihone
*  @since 2024/12/9 21:50
*/
public class IsValid {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c=='{') {
                list.push(c);
            }else {
                Character part = map.get(c);
                if (part == list.peek()) {
                    list.pop();
                }
                else {
                    return false;
                }


            }
        }
        return list.isEmpty();

    }
}

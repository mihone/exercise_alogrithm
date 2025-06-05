package com.exercise.algorithm.hot100.v2.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

       letterCombinations(digits, 0, sb, map, ret);

        return ret;

    }

    public void letterCombinations(String digits,int cur, StringBuilder sb, Map<Character, String> map, List<String> ret) {
        if (cur >=digits.length()) {
            ret.add(sb.toString());
            return;
        }
        char d = digits.charAt(cur);
        String str = map.get(d);

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            letterCombinations(digits, cur + 1, sb, map, ret);
            sb.delete(sb.length() - 1, sb.length());
        }

    }
}

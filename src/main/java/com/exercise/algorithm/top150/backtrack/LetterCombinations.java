package com.exercise.algorithm.top150.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 *
 * @author mihone
 * @since 2025/1/11 13:45
 */
public class LetterCombinations {
    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        List<String> result = new ArrayList<>();
        back(phoneMap, 0, result, new StringBuilder(), digits);

        return result;


    }

    public void back(Map<Character, String> phoneMap, int cur, List<String> result, StringBuilder sb, String digits) {
        if (cur == digits.length()) {
            result.add(sb.toString());
            return;
        }
        char d = digits.charAt(cur);
        String s = phoneMap.get(d);
        for (int j = 0; j < s.length(); j++) {
            String alpha = s.substring(j, j + 1);
            sb.append(alpha);
            back(phoneMap, cur + 1, result, sb, digits);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}

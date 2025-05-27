package com.exercise.algorithm.hot100.v1.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 *
 * @author mihone
 * @since 2025/2/9 17:21
 */
public class LetterCombinations {
    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<String>();
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder sb = new StringBuilder();
        internal(res, sb, 0, digits, map);
        return res;

    }

    public void internal(List<String> res, StringBuilder sb, int cur, String digits, Map<Character, String> map) {
        if (cur == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(cur);
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            internal(res, sb, cur + 1, digits, map);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}

package com.exercise.algorithm.hot100.v2.backtrack;

import java.util.*;

/**
 * [REPEAT]
 *
 * @author mihone
 * @since 2025/6/5 10:53
 */
public class GenerateParenthesis {


    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesis(n, 0, 0, n * 2, sb, ret);
        return ret;

    }


    public void generateParenthesis(int n, int open, int close, int max,
                                    StringBuilder sb, List<String> ret) {

        if (sb.length() == max) {
            ret.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            generateParenthesis(n, open + 1, close, max, sb, ret);
            sb.delete(sb.length() - 1, sb.length());
        }
        if (close < open) {
            sb.append(")");
            generateParenthesis(n, open, close + 1, max, sb, ret);
            sb.delete(sb.length() - 1, sb.length());
        }

    }


    //去重法
    public List<String> generateParenthesis2(int n) {
        Set<String> ret = new HashSet<>();
        ret.add("()");
        if (n ==1) {
            return new ArrayList<>(ret);
        }

        StringBuilder s = new StringBuilder("()");

        Set<String> p = new HashSet<>();
        p.add("()");
        for (int i = 1; i < n; i++) {
            List<String> t = new ArrayList<>(p);
            p.clear();
            for (String s1 : t) {
                s.setLength(0);
                s.append(s1);
                for (int j = 0; j < s.length(); j++) {
                    s.insert(j, "()");
                    p.add(s.toString());
                    s.replace(j, j + 2, "");
                }
            }
        }
        return new ArrayList<>(p);
    }


}

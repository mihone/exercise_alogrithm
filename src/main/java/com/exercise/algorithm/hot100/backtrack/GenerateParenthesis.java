package com.exercise.algorithm.hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * [REPEAT]
 * 22. 括号生成
 *
 * @author mihone
 * @since 2025/3/3 20:18
 */
public class GenerateParenthesis {

    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        internal(res, new StringBuilder(), n * 2, 0, 0);
        return res;

    }

    public void internal(List<String> ret, StringBuilder sb, int max, int open, int close) {
        if (sb.length() == max) {
            ret.add(sb.toString());
            return;
        }
        int n = max / 2;
        if (open < n) {
            sb.append("(");
            internal(ret, sb, max, open+1, close);
            sb.delete(sb.length() - 1, sb.length());
        }
        if (close < open) {
            sb.append(")");
            internal(ret, sb, max, open, close+1);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}

package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

/**
 * LCR 085. 括号生成
 *
 * @author mihone
 * @since 2025/9/27 18:28
 */
public class LCR085 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        cal(res, new StringBuilder(), n, 0, 0);
        return res;

    }

    public void cal(List<String> ret, StringBuilder sb, int n, int open, int close) {
        if (sb.length() == 2 * n) {
            ret.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            cal(ret, sb, n, open + 1, close);
            sb.delete(sb.length() - 1,sb.length());
        }
        if (close < open) {
            sb.append(")");
            cal(ret, sb, n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}

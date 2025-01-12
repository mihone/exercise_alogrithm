package com.exercise.algorithm.top150.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * [ENHANCE]
 * 原因，需要记住官方的方法。
 * 22. 括号生成
*  @author mihone
*  @since 2025/1/11 14:15
*/
public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(3);
        System.out.println(strings);

    }


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.delete(cur.length() - 1, cur.length());
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.delete(cur.length() - 1, cur.length());
        }
    }


}

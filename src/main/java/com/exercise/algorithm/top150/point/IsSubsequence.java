package com.exercise.algorithm.top150.point;

/**
 * 392. 判断子序列
 *
 * @author mihone
 * @since 2024/12/3 8:08
 */
public class IsSubsequence {

    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (t == null || t.isEmpty()) {
            return false;
        }
        int si = 0;
        int ti = 0;

        while (si < s.length() && ti < t.length()) {
            while (ti < t.length() && s.charAt(si) != t.charAt(ti)) {
                ti++;
            }
            if (ti < t.length()) {
                si++;
            }
            ti++;


        }
        return si == s.length();

    }
}

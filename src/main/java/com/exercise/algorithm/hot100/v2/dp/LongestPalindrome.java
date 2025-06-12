package com.exercise.algorithm.hot100.v2.dp;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int l = 2;

        int max = 1;
        String ret = s.substring(0,1);
        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j < s.length(); j ++) {
                String internal = internal(s, j, j + i - 1);
                if (internal!=null&&internal.length()>0 && internal.length()>max) {
                    max = internal.length();
                    ret = internal;
                }
            }
        }
        return ret;

    }

    public String internal(String s, int start,int end){
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}

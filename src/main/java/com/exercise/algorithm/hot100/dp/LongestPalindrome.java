package com.exercise.algorithm.hot100.dp;
/**
 * 5. 最长回文子串
*  @author mihone
*  @since 2025/3/15 11:00
*/
public class LongestPalindrome {

    public static void main(String[] args) {

    }
    public String longestPalindrome(String s) {
        if (s.length()<=1) {
            return s;
        }
        int init = 2;
        String ret = s.charAt(0)+"";
        for (int i = 1; i <= init; i++) {
            int index = 0;
            while (index < s.length()) {
                String substring = cal(s, index, index + i);
                if (substring.length() > ret.length()) {
                    ret = substring;
                }
                index++;
            }
        }
        return ret;

    }

    public String cal(String s, int left, int right) {
        if (right >= s.length()) {
            return "";
        }
        while (right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }


}

package com.exercise.algorithm.top150.point;
/**
 * 125. 验证回文串
*  @author mihone
*  @since 2024/11/29 8:32
*/
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if (s==null || s.length()==0) {
            return true;
        }
        return isPalindrome(s, 0, s.length() - 1);

    }

    public boolean isPalindrome(String s,int start,int end) {
        while (start < end) {
            if (!Character.isDigit(s.charAt(start)) &&!Character.isLetter(s.charAt(start))) {
                start++;
                continue;
            }
            if (!Character.isDigit(s.charAt(end)) &&!Character.isLetter(s.charAt(end))) {
                end--;
                continue;
            }
            ;
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

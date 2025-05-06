package com.exercise.algorithm.lcr;
/**
 * LCR 018. 验证回文串
*  @author mihone
*  @since 2025/5/6 20:19
*/
public class LCR018 {
    public static void main(String[] args) {

        LCR018 lcr018 = new LCR018();
        System.out.println(lcr018.isPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));

    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length()==0) {
            return true;
        }
        int l = 0;
        int r = s.length()-1;
        while (l < r) {
            if (!Character.isLetter(s.charAt(l)) && !Character.isDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if (!Character.isLetter(s.charAt(r)) && !Character.isDigit(s.charAt(r))) {
                r--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;

    }
}

package com.exercise.algorithm.lcr;

/**
 * LCR 019. 验证回文串 II
 *
 * @author mihone
 * @since 2025/5/6 20:29
 */
public class LCR019 {
    public static void main(String[] args) {
        LCR019 lcr019 = new LCR019();
        System.out.println(lcr019.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));


    }

    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        return validPalindrome(s, 0, s.length() - 1, false);
    }



    public boolean validPalindrome(String s,int l,int r,boolean flag) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
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
                if (flag) {
                    return false;
                }
                boolean a = validPalindrome(s, l + 1, r, true);
                boolean b = validPalindrome(s, l, r - 1, true);
                return a || b;
            }
            l++;
            r--;
        }
        return true;
    }
    //aguokepatgbnvfqmgml cupuufxooh dfpgj dmy sgv hmvff cnqxjjxqnc ffvmh vgs ymd jgpfd hooxfuupucu lmgmqfvnbgtapekouga
}

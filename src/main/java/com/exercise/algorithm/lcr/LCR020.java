package com.exercise.algorithm.lcr;

import javax.xml.crypto.dom.DOMCryptoContext;

/**
 * LCR 020. 回文子串
*  @author mihone
*  @since 2025/5/7 21:42
*/
public class LCR020 {

    public int countSubstrings(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int ret = 0;

        for (int i = 1; i <= n; i++) {
            int start = 0;
            while (start < s.length() && start + i <= s.length()) {
                String substring = s.substring(start, start + i);
                boolean valid = valid(substring);
                if (valid) {
                    ret++;
                }
                start++;
            }
        }
        return ret;

    }

    public boolean valid(String s){
        int l = 0;
        int r = s.length()-1;
        while (l < r) {
            if (s.charAt(l)!=s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        LCR020 lcr = new LCR020();
    }
}

package com.exercise.algorithm.lcr;

/**
 * LCR 002. 二进制求和
 *
 * @author mihone
 * @since 2025/3/25 21:24
 */
public class LCR002 {

    public static void main(String[] args) {
        LCR002 lcr002 = new LCR002();
        System.out.println(lcr002.addBinary2("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    public String addBinary2(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        while (aIndex >= 0 || bIndex >=0) {
            if (aIndex >= 0) {
                carry += a.charAt(aIndex) - '0';
                aIndex--;
            }
            if (bIndex >=0) {
                carry += b.charAt(bIndex) - '0';
                bIndex--;
            }
            ans.insert(0,carry % 2);
            carry /= 2;

        }

        if (carry > 0) {
            ans.insert(0,1);
        }

        return ans.toString();
    }

}

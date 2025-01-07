package com.exercise.algorithm.top150.bit;
/**
 * 67. 二进制求和
*  @author mihone
*  @since 2025/1/7 20:44
*/
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.insert(0,(char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.insert(0,'1');
        }

        return ans.toString();
    }


    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        addBinary.addBinary("11", "1");

    }
}

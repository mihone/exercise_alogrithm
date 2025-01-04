package com.exercise.algorithm.top150.array;

/**
 * 28. 找出字符串中第一个匹配项的下标
 *
 * @author mihone
 * @since 2024/11/29 8:26
 */
public class StrStr {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        int index = 0;
        while (index < haystack.length()) {
            int pi = index;
            int p = 0;
            while (p < needle.length() && pi < haystack.length() && haystack.charAt(pi) == needle.charAt(p)) {
                p++;
                pi++;
            }
            if (p == needle.length()) {
                return index;
            }

            index++;


        }
        return -1;

    }
}

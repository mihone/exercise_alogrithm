package com.exercise.algorithm.top150.array;

/**
 *
 * 14. 最长公共前缀
 * @author mihone
 * @since 2024/11/26 8:17
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(new StringBuilder().toString());
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = cal(prefix, strs[i]);
            if ("".equals(prefix)) {
                return prefix;
            }
        }
        return prefix;

    }

    private String cal(String prefix, String str) {
        int index = 0;
        StringBuilder pre = new StringBuilder();
        while (index < str.length() && index < prefix.length()) {
            if (str.charAt(index) != prefix.charAt(index)) {
                break;
            }
            pre.append(str.charAt(index));
            index++;

        }
        return pre.toString();
    }
}

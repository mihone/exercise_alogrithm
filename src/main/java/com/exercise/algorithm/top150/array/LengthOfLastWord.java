package com.exercise.algorithm.top150.array;

/**
 * 58. 最后一个单词的长度
 *
 * @author mihone
 * @since 2024/11/25 8:22
 */
public class LengthOfLastWord {
    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        if (i < 0) {
            return 0;
        }
        int cnt = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            cnt++;
        }
        return cnt;

    }


}

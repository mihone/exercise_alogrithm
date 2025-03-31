package com.exercise.algorithm.lcr;

import java.util.*;

/**
 * [REPEAT]
 * LCR 005. 最大单词长度乘积
*  @author mihone
*  @since 2025/3/31 20:21
*/
public class LCR005 {
    public static void main(String[] args) {

    }
    //位运算
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }

}

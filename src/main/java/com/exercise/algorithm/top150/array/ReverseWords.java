package com.exercise.algorithm.top150.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * 151. 反转字符串中的单词
*  @author mihone
*  @since 2024/11/26 8:33
*/
public class ReverseWords {


    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

}

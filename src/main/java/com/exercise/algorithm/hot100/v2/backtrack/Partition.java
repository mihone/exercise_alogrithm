package com.exercise.algorithm.hot100.v2.backtrack;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * [ENHANCE] 注意边界
*  @author mihone
*  @since 2025/6/5 14:32
*/
public class Partition {


    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ret;
        }
        partition(s, 0, new ArrayList<>(), ret);
        return ret;
    }


    public void partition(String s, int start, List<String> part, List<List<String>> ret) {

        if (start >= s.length()) {
            ret.add(new ArrayList<>(part));
            return;
        }

        for (int i = 1; start + i <= s.length(); i++) {
            String substring = s.substring(start, start + i);
            if (isPalindrome(substring, 0, substring.length() - 1)) {
                part.add(substring);
                partition(s, start + i, part, ret);
                part.remove(part.size() - 1);
            }

        }

    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

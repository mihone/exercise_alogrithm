package com.exercise.algorithm.hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * [REPEAT]
 * 131. 分割回文串
 *
 * @author mihone
 * @since 2025/3/4 21:09
 */
public class Partition {
    public static void main(String[] args) {
        Partition partition = new Partition();
        System.out.println(partition.partition("aab"));

    }

    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        List<String> part = new ArrayList<>();
        internal(s,ret,part,0);
        return ret;

    }

    public void internal(String s, List<List<String>> ret, List<String> part, int cur) {
        if (cur >= s.length()) {
            if (!part.isEmpty()) {
                ret.add(new ArrayList<>(part));
            }
            return;
        }


        for (int i = 1; i <= s.length()-cur; i++) {
            String substring = s.substring(cur, cur + i);
            boolean judge = judge(substring);
            if (!judge) {
                continue;
            }
            part.add(substring);
            internal(s, ret, part,  cur + i);
            part.remove(part.size() - 1);
        }
    }

    public boolean judge(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }else {
                return false;
            }
        }
        return true;

    }
}

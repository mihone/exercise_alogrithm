package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

/**
 * LCR 086. 分割回文串
*  @author mihone
*  @since 2025/9/27 18:34
*/
public class LCR086 {

    public String[][] partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        internal(s, ret, new ArrayList<>(), 0);
        String[][] res =  new String[ret.size()][];
        for (int i = 0; i < ret.size(); i++) {
            res[i] = ret.get(i).toArray(new String[0]);
        }
        return res;

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

package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

/**
 * LCR 087. 复原 IP 地址
 *
 * @author mihone
 * @since 2025/9/27 18:40
 */
public class LCR087 {
    public static void main(String[] args) {
        LCR087 lcr087 = new LCR087();
        System.out.println(lcr087.restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        cal(s, res, new StringBuilder(), 0, 0);
        return res;

    }

    public void cal(String s, List<String> ret, StringBuilder sb, int cur, int count) {
        if (count == 4) {
            if (cur == s.length()) {
                ret.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (cur + i + 1 > s.length()) {
                break;
            }
            String substring = s.substring(cur, cur + i + 1);
            if (substring.startsWith("0") && substring.length() > 1) {
                continue;
            }
            int p = Integer.parseInt(substring);
            if (p > 255) {
                continue;
            }
            sb.append(substring).append(".");
            cal(s, ret, sb, cur + i + 1, count + 1);
            sb.delete(sb.length() - 1 - i-1, sb.length());
        }

    }
}

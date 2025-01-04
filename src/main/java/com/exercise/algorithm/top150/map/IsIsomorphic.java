package com.exercise.algorithm.top150.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 *
 * @author mihone
 * @since 2024/12/7 17:52
 */
public class IsIsomorphic {

    public static void main(String[] args) {

    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        if (s == null | t == null || s.length() != t.length()) {
            return false;
        }
        int index = 0;
        while (index < s.length()) {
            char sc = s.charAt(index);
            char tc = t.charAt(index);
            Character c = map.get(sc);
            if (c == null) {
                map.put(sc, tc);
            }else if (c != tc) {
                return false;
            }

            Character c2 = tmap.get(tc);
            if (c2 == null) {
                tmap.put(tc, sc);
            }else if (c2 != sc) {
                return false;
            }
            index++;
        }
        return true;


    }
}

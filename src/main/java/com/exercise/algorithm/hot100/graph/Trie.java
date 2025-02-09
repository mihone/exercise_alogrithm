package com.exercise.algorithm.hot100.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. 实现 Trie (前缀树)
 *
 * @author mihone
 * @since 2025/2/9 16:45
 */
public class Trie {

    public static void main(String[] args) {

    }

    Map<Character, Trie> map = new HashMap<>();
    boolean word;


    public Trie() {

    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Trie t = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Trie temp = t.map.get(c);
            if (temp == null) {
                temp = new Trie();
                t.map.put(c, temp);
            }
            t = temp;
        }
        t.word = true;

    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        Trie t = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Trie temp = t.map.get(c);
            if (temp == null) {
                return false;
            }
            t = temp;
        }
        return t.word;

    }

    public boolean startsWith(String prefix) {
        Trie t = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Trie temp = t.map.get(c);
            if (temp == null) {
                return false;
            }
            t = temp;
        }
        return true;

    }
}

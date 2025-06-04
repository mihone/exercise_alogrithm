package com.exercise.algorithm.hot100.v2.graph;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.startsWith("a"));
    }

    Map<Character, Trie> map = new HashMap<>();
    boolean end ;

    public Trie() {

    }

    public void insert(String word) {
        if (word.length() == 0) {
            return;
        }
        Trie t = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Trie trie = t.map.get(c);
            if (trie == null) {
                trie = new Trie();
                t.map.put(c, trie);
            }
            t = trie;
        }
        t.end = true;
    }

    public boolean search(String word) {
        Trie prefix = prefix(word);
        return prefix !=null && prefix.end;

    }

    public boolean startsWith(String prefix) {
        Trie p = prefix(prefix);
        return p !=null;
    }

    private Trie prefix(String prefix) {
        if (prefix.length() == 0) {
            return null;
        }
        Trie t = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Trie trie = t.map.get(c);
            if (trie == null) {
                return null;
            }
            t = trie;
        }
        return t;

    }
}
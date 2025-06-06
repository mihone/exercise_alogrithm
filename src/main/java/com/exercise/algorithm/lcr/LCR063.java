package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [ENHANCE]
 * LCR 063. 单词替换
 *
 * @author mihone
 * @since 2025/5/21 22:51
 */
public class LCR063 {

    public static void main(String[] args) {

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        List<String> result = new ArrayList<>();
        String[] split = sentence.split(" ");
        for (String s : split) {
            String s1 = trie.startsWith(s);
            if (s1!=null && s1.length()>0) {
                result.add(s1);
            }else {
                result.add(s);
            }
        }
        return String.join(" ", result);
    }


    static class Trie {
        private Map<Character, Trie> children;
        private boolean end;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            children = new HashMap<Character, Trie>();

        }


        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie t = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Trie cTrie = t.children.get(c);
                if (cTrie == null) {
                    cTrie = new Trie();
                    t.children.put(c, cTrie);
                }
                t = cTrie;

            }
            t.end = true;

        }


        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public String startsWith(String prefix) {
            Trie t = this;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                Trie cTrie = t.children.get(c);
                if (t.end) {
                    return stringBuilder.toString();
                }
                if (cTrie == null) {
                    return null;
                }
                stringBuilder.append(c);
                t = cTrie;
            }
            return stringBuilder.toString();
        }
    }
}

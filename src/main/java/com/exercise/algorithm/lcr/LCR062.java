package com.exercise.algorithm.lcr;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * LCR 062. 实现 Trie (前缀树)
*  @author mihone
*  @since 2025/5/21 22:41
*/
public class LCR062 {

    public static void main(String[] args) {

    }
    static class Trie {
        private Map<Character, Trie> children;
        private boolean end;

        /** Initialize your data structure here. */
        public Trie() {
            children = new HashMap<Character, Trie>();

        }


        /** Inserts a word into the trie. */
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

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie trie = searchInternal(word);
            return trie != null && trie.end;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return searchInternal(prefix) != null;

        }

        public Trie searchInternal(String prefix) {
            Trie t = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                Trie cTrie = t.children.get(c);
                if (cTrie == null) {
                    return null;
                }
                t = cTrie;

            }
            return t;
        }
    }

}

package com.exercise.algorithm.lcr;

import java.util.HashMap;
import java.util.Map;

/**
 * [REPEAT]
 * LCR 065. 单词的压缩编码
 *
 * @author mihone
 * @since 2025/9/2 21:18
 */
public class LCR065 {


    public int minimumLengthEncoding(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap<TrieNode, Integer>();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j) {
                cur = cur.get(word.charAt(j));
            }
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node : nodes.keySet()) {
            if (node.count == 0) {
                ans += words[nodes.get(node)].length() + 1;
            }
        }
        return ans;

    }
    class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }

        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }
}



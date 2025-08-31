package com.exercise.algorithm.lcr;
/**
 * [REPEAT]
 * LCR 064. 实现一个魔法字典
*  @author mihone
*  @since 2025/5/21 23:17
*/
public class LCR064 {

    public static void main(String[] args) {
        String[] dict = new String[]{"hello","leetcode"};
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(dict);
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("leetcode"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));

    }

   static class MagicDictionary {
       Trie root;

    public MagicDictionary() {
           root = new Trie();
       }

       public void buildDict(String[] dictionary) {
           for (String word : dictionary) {
               Trie cur = root;
               for (int i = 0; i < word.length(); ++i) {
                   char ch = word.charAt(i);
                   int idx = ch - 'a';
                   if (cur.child[idx] == null) {
                       cur.child[idx] = new Trie();
                   }
                   cur = cur.child[idx];
               }
               cur.isFinished = true;
           }
       }

       public boolean search(String searchWord) {
           return dfs(searchWord, root, 0, false);
       }

       private boolean dfs(String searchWord, Trie node, int pos, boolean modified) {
           if (pos == searchWord.length()) {
               return modified && node.isFinished;
           }
           int idx = searchWord.charAt(pos) - 'a';
           if (node.child[idx] != null) {
               if (dfs(searchWord, node.child[idx], pos + 1, modified)) {
                   return true;
               }
           }
           if (!modified) {
               for (int i = 0; i < 26; ++i) {
                   if (i != idx && node.child[i] != null) {
                       if (dfs(searchWord, node.child[i], pos + 1, true)) {
                           return true;
                       }
                   }
               }
           }
           return false;
       }
   }

    static class Trie {
        boolean isFinished;
        Trie[] child;

        public Trie() {
            isFinished = false;
            child = new Trie[26];
        }
    }
    class MagicDictionary2 {
        private String[] words;

        public MagicDictionary2() {

        }

        public void buildDict(String[] dictionary) {
            words = dictionary;
        }

        public boolean search(String searchWord) {
            for (String word : words) {
                if (word.length() != searchWord.length()) {
                    continue;
                }

                int diff = 0;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) != searchWord.charAt(i)) {
                        ++diff;
                        if (diff > 1) {
                            break;
                        }
                    }
                }
                if (diff == 1) {
                    return true;
                }
            }
            return false;
        }
    }


}

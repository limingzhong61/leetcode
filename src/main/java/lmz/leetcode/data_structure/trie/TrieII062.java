package lmz.leetcode.data_structure.trie;


import java.util.HashMap;
import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-03-21 10:00
 */
public class TrieII062 {
    /**
     *通用字典树
     */
    class Trie {
        final char endChar = '#';
        HashMap<Character, Trie> children;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            children = new HashMap<>();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie cur = this;
            for (var c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.putIfAbsent(endChar, new Trie());
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.children.containsKey(endChar);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        /**
         * 返回搜索到指定prefix字符串的最后一个Trie结点
         *
         * @param prefix
         * @return
         */
        private Trie searchPrefix(String prefix) {
            Trie cur = this;
            for (var c : prefix.toCharArray()) {
                cur = cur.children.get(c);
                if (cur == null) {
                    return null;
                }
            }
            return cur;
        }
    }
}

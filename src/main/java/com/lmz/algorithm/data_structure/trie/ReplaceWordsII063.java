package com.lmz.algorithm.data_structure.trie;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author: limingzhong
 * @create: 2023-03-21 10:51
 */
public class ReplaceWordsII063 {
    /**
     * 字典树
     * 用dict构造字典树
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (var s : dictionary) {
            trie.insert(s);
        }
        StringBuilder sb = new StringBuilder();
        for (var s : sentence.split(" ")) {
            sb.append(Trie.findShortestPrefix(trie, s)).append(' ');
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    

    /**
     * 字典树模板 Trie Tree
     * 用一个hashMap来完成结点间的映射查找，"#"为一个完整字符串的结束标记。
     */
    public class Trie {
        final char endChar = '#';
        Map<Character, Trie> children;

        public Trie() {
            children = new HashMap<>();
        }

        public Trie(List<String> dictionary) {
            this();
            for (String word : dictionary) {
                insert(word);
            }
        }

        public Trie(String[] dictionary) {
            this();
            for (String word : dictionary) {
                insert(word);
            }
        }

        /**
         * 在字典树中插入一个字符串
         *
         * @param word 字符串
         */
        private void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.putIfAbsent(endChar, new Trie());
        }

        /**
         * 找到字符串s在字典树trie中的最短前缀串
         */
        public static String findShortestPrefix(Trie trie, String s) {
            Trie cur = trie;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                cur = cur.children.get(c);
                if (cur == null) { // 没有找到前缀
                    return s;
                } else if (cur.children.containsKey('#')) {
                    return s.substring(0, i + 1);
                }
            }
            return s;
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

package lmz.my.solution_template.data_structure.trie;

import java.util.*;
/**
 * 字典树 Trie Tree
 * 用一个hashMap来完成结点间的映射查找，"#"为一个完整字符串的结束标记。
 */
public class Trie {

    Map<Character, Trie> children;

    public Trie() {
        children = new HashMap<>();
    }

    public  Trie(List<String> dictionary) {
        this();
        for (String word : dictionary) {
            insert(word);
        }
    }
    public  Trie(String[] dictionary) {
        this();
        for (String word : dictionary) {
            insert(word);
        }
    }

    /**
     * 在字典树中插入一个字符串
     * @param word  字符串
     */
    private  void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cur.children.putIfAbsent(c, new Trie());
            cur = cur.children.get(c);
        }
        cur.children.putIfAbsent('#', new Trie());
    }

    public String findRoot(String word, Trie trie) {
        StringBuilder root = new StringBuilder();
        Trie cur =trie;
        for(var c : word.toCharArray()){
            if (cur.children.containsKey('#')) {
                return root.toString();
            }
            if(!cur.children.containsKey(c)){
                return word; //没找到，返回原字符串
            }
            root.append(c);
            cur = cur.children.get(c);
        }
        return root.toString();
    }
}

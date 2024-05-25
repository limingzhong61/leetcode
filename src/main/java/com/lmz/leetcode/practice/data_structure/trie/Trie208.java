package com.lmz.leetcode.practice.data_structure.trie;

import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-06-28 21:30
 */
public class Trie208 {
    class Trie {
        //该结点是否是一个串的结束
        boolean isEnd;
        //字符映射
        HashMap<Character,Trie> map = new HashMap<>();
        public Trie() {
        }

        public void insert(String word) {
            Trie cur = this;
            for(char c : word.toCharArray()){
                cur.map.putIfAbsent(c,new Trie());
                cur = cur.map.get(c);
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {
            Trie cur = this;
            for(char c : word.toCharArray()){
                if(!cur.map.containsKey(c)){
                    return false;
                }
                cur = cur.map.get(c);
            }
            return cur.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie cur = this;
            for(char c : prefix.toCharArray()){
                if(!cur.map.containsKey(c)){
                    return false;
                }
                cur = cur.map.get(c);
            }
            return true;
        }
    }
}

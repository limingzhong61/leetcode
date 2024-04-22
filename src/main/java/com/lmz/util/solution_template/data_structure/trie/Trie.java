package com.lmz.util.solution_template.data_structure.trie;

import java.util.*;

/**
 * 字典树模板 Trie Tree
 * 用一个hashMap来完成结点间的映射查找，一个boolean表示一个完整字符串的结束标记。
 */
public class Trie {
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
            System.out.println(c);
            if(cur.map.containsKey(c)){
                cur = cur.map.get(c);
            }else{
                return false;
            }
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie cur = this;
        for(char c : prefix.toCharArray()){
            if(cur.map.containsKey(c)){
                cur = cur.map.get(c);
            }else{
                return false;
            }
        }
        return true;
    }
}

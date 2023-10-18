package com.lmz.algorithm_practice.contest.old.c311;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.*;

public class SumPrefixScores {
    //public int[] sumPrefixScores(String[] words) {
    //    Map<String, Integer> cntMap = new HashMap<>();
    //    int len = words.length;
    //    int[] res = new int[len];
    //    for (int i = 0; i < words.length; i++) {
    //        String word = words[i];
    //        int sum = 0;
    //        for (int j = 1; j <= word.length(); j++) {
    //            String subStr = word.substring(0, j);
    //            if (cntMap.containsKey(subStr)) {
    //                sum += cntMap.get(subStr);
    //            } else {
    //                int cnt = 0;
    //                for (String word1 : words) {
    //                    if (word1.startsWith(subStr)) {
    //                        cnt++;
    //                    }
    //                }
    //                cntMap.put(subStr, cnt);
    //                sum += cnt;
    //            }
    //        }
    //        res[i] = sum;
    //    }
    //    return res;
    //}
    public int[] sumPrefixScores(String[] words) {
        Map<String, Integer> cntMap = new HashMap<>();
        int len = words.length;
        int[] res = new int[len];
        Trie trie = new Trie(words);
        for(int i = 0; i < len; i++){
            res[i] = trie.findRoot(words[i],trie);
        }
        return res;
    }
    /**
     * 通用泛型Pair类型
     */
    public class Pair<V1, V2> {
        public V1 val1;
        public V2 val2;
        public Pair() {}

        public Pair(V1 val1, V2 val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }

    /**
     * 字典树 Trie Tree
     * 用一个hashMap来完成结点间的映射查找，"#"为一个完整字符串的结束标记。
     */
    class Trie {
        Map<Character, Trie> children;
        int cnt = 0;
        public Trie() {
            children = new HashMap<>();
        }

        public Trie(String[] dictionary) {
            this();
            for (String word : dictionary) {
                Trie cur = this;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    cur.children.putIfAbsent(c, new Trie());
                    cur = cur.children.get(c);
                    cur.cnt++;
                }
                cur.children.putIfAbsent('#', new Trie());
            }
        }



        public int findRoot(String word, Trie trie) {
            int sum = 0;
            Trie cur = trie;
            for (var c : word.toCharArray()) {
                cur = cur.children.get(c);
                sum += cur.cnt;
            }
            return sum;
        }

    }

    public static void main(String[] args) {
        SumPrefixScores sumPrefixScores = new SumPrefixScores();
        System.out.println(Arrays.toString(sumPrefixScores.sumPrefixScores(TransformUtil.toStringArray("[\"abc\",\"ab\",\"bc\",\"b\"]"))));
    }
}

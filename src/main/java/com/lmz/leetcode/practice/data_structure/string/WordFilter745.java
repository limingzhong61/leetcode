package com.lmz.leetcode.practice.data_structure.string;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.HashMap;
import java.util.Map;

public class WordFilter745 {
    /**
     * leetcode:Trie字典树
     */
    static class WordFilter {
        Trie trie;
        String weightKey;

        public WordFilter(String[] words) {
            trie = new Trie();
            weightKey = "##";
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                Trie cur = trie;
                int m = word.length();
                for (int j = 0; j < m; j++) {
                    Trie tmp = cur;
                    for (int k = j; k < m; k++) {
                        String key = new StringBuilder().append(word.charAt(k)).append('#').toString();
                        if (!tmp.children.containsKey(key)) {
                            tmp.children.put(key, new Trie());
                        }
                        tmp = tmp.children.get(key);
                        tmp.weight.put(weightKey, i);
                    }
                    tmp = cur;
                    for (int k = j; k < m; k++) {
                        String key = new StringBuilder().append('#').append(word.charAt(m - k - 1)).toString();
                        if (!tmp.children.containsKey(key)) {
                            tmp.children.put(key, new Trie());
                        }
                        tmp = tmp.children.get(key);
                        tmp.weight.put(weightKey, i);
                    }
                    String key = new StringBuilder().append(word.charAt(j)).append(word.charAt(m - j - 1)).toString();
                    if (!cur.children.containsKey(key)) {
                        cur.children.put(key, new Trie());
                    }
                    cur = cur.children.get(key);
                    cur.weight.put(weightKey, i);
                }
            }
        }

        public int f(String pref, String suff) {
            Trie cur = trie;
            int m = Math.max(pref.length(), suff.length());
            for (int i = 0; i < m; i++) {
                char c1 = i < pref.length() ? pref.charAt(i) : '#';
                char c2 = i < suff.length() ? suff.charAt(suff.length() - 1 - i) : '#';
                String key = new StringBuilder().append(c1).append(c2).toString();
                if (!cur.children.containsKey(key)) {
                    return -1;
                }
                cur = cur.children.get(key);
            }
            return cur.weight.get(weightKey);
        }
    }

    static class Trie {
        Map<String, Trie> children;
        Map<String, Integer> weight;

        public Trie() {
            children = new HashMap<String, Trie>();
            weight = new HashMap<String, Integer>();
        }
    }

    /**
     * leetcode:hashMap<pref+' '+suff,maxIndex>
     * 把每个字符串所有可能的前缀和后缀全都穷举出来一起放到hash表里面
     */
    static class WordFilter2 {
        Map<String, Integer> wordMap = new HashMap<>();

        public WordFilter2(String[] words) {
            //枚举所有可能的前后缀
            //1 <= pref.length, suff.length <= 7
            for (int k = 0; k < words.length; k++) {
                int len = words[k].length();
                for (int i = 1; i <= len && i <= 7; i++) {
                    for (int j = 1; j <= len && j <= 7; j++) {
                        //后来的k肯定更大
                        wordMap.put(words[k].substring(0, i) + " " + words[k].substring(len - j, len), k);
                    }
                }
            }
        }

        public int f(String pref, String suff) {
            return wordMap.getOrDefault(pref + " " + suff, -1);
        }
    }

    /**
     * 超时
     */
    static class WordFilter1 {
        String[] words;

        public WordFilter1(String[] words) {
            this.words = words;
        }

        public int f(String pref, String suff) {
            for (int i = words.length - 1; i >= 0; i--) {
                if (words[i].endsWith(suff) && words[i].startsWith(pref)) {
                    return i;
                }
            }
            return -1;
        }
    }


    public static void main(String[] args) {
        testCase("[[\"apple\"]]", "[\"a\", \"e\"]");
        testCase("[[\"apple\"]]", "[\"b\",\"e\"]");
        testCase("[[[\"apple\"]], [\"a\", \"e\"]]");
        testCase("[[[\"c\"]], [\"c\", \"c\"]]");
    }

    private static void testCase(String s) {
    //    [[["apple"]], ["a", "e"]] format-input
        s = s.substring(1);
        String[] split = s.split("]]");
        //[["apple"
        String s1 = split[0].replaceAll("\\[", "");
        // ["a", "e"
        String s2 = split[1].substring(1) + "]";
        testCase(s1,s2);
    }

    private static void testCase(String s1, String s2) {
        WordFilter wordFilter = new WordFilter(TransformUtil.toStringArray(s1));
        String[] fStr = TransformUtil.toStringArray(s2);
        System.out.println(wordFilter.f(fStr[0], fStr[1]));
    }
}

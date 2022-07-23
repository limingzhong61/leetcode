package codeofli.leetcode.everyday.code_ability;

import codeofli.my.leetcode.StringTransformUtil;

import java.util.*;

class Trie {
    boolean isFinished;
    Trie[] child;

    public Trie() {
        isFinished = false;
        child = new Trie[26];
    }

    public Trie(String[] dictionary) {
        this();
        for (String s : dictionary) {
            Trie cur = this;
            for (char c : s.toCharArray()) {
                int cIndex = c - 'a';
                Trie nextChild = cur.child[cIndex];
                if (nextChild == null) {
                    cur.child[cIndex] = new Trie();
                }
                cur = cur.child[cIndex];
            }
            cur.isFinished = true;
        }

    }
}

/**
 * leetcode:方法一：枚举每个字典中的字符串并判断
 * list存储，遍历匹配
 */
class MagicDictionary {
    Trie tire;

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        tire = new Trie(dictionary);
    }

    public boolean search(String searchWord) {
        return search(searchWord, 0, tire, false);
    }

    /**
     * 当前遍历到的字典树上的节点是 node 以及待查询字符串 searchWord 的第 pos 个字符，并且在之前的遍历中是否已经替换过恰好一个字符（如果替换过，
     * 那么 modified 为 true，否则为 false）。
     */
    private boolean search(String searchWord, int pos, Trie node, boolean modified) {
        if (pos == searchWord.length()) {
            return modified && node.isFinished;
        }
        int idx = searchWord.charAt(pos) - 'a';
        if (node.child[idx] != null) {
            if (search(searchWord, pos + 1, node.child[idx], modified)) {
                return true;
            }
        }
        if (!modified) {
            for (int i = 0; i < 26; i++) {
                if (i != idx && node.child[i] != null) {
                    if (search(searchWord, pos + 1, node.child[i], true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

public class MagicDictionary676 {


    /**
     * leetcode:方法一：枚举每个字典中的字符串并判断
     * list存储，遍历匹配
     */
    class MagicDictionary2 {
        String[] words;

        public MagicDictionary2() {

        }

        public void buildDict(String[] dictionary) {
            words = dictionary;
        }

        public boolean search(String searchWord) {
            for (var word : words) {
                if (word.length() != searchWord.length()) {
                    continue;
                }
                int diff = 0;
                for (int i = 0; i < searchWord.length(); i++) {
                    if (word.charAt(i) != searchWord.charAt(i)) {
                        diff++;
                    }
                    if (diff >= 2) {
                        break;
                    }
                }
                if (diff == 1) {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * my: hase存储，枚举可能
     */
    class MagicDictionary1 {
        Set<String> set = new HashSet<>();

        public MagicDictionary1() {

        }

        public void buildDict(String[] dictionary) {
            set.addAll(Arrays.asList(dictionary));
        }

        public boolean search(String searchWord) {
            char[] chars = searchWord.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < 26; j++) {
                    if (j + 'a' != chars[i]) {
                        char temp = chars[i];
                        chars[i] = (char) (j + 'a');
                        if (set.contains(String.valueOf(chars))) {
                            return true;
                        }
                        chars[i] = temp;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        //testCase("[\"hello\",\"hallo\",\"leetcode\"]", TransformUtil.toStringArrayList("[\"hello\"]"));
        testCase("[[\"hello\",\"hallo\",\"leetcode\",\"judge\", \"judgg\"]]",
                //
                StringTransformUtil.toStringArrayList("[\"hello\" ,  \"hallo\" ,  \"hell\" ,  \"leetcodd\" ,  \"judge\" ,\"juggg\"]"));
//
//[[], ,
    }

    private static void testCase(String str, List<String> list) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(StringTransformUtil.toStringArray(str));
        //    [[], [["hello","hallo","leetcode"]], ["hello"], ["hallo"], ["hell"], ["leetcodd"]]
        for (var s : list) {

            System.out.println(magicDictionary.search(s));
        }
    }
}

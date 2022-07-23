package codeofli.my.solution_template.data_structure;

import codeofli.my.leetcode.StringTransformUtil;

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
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.putIfAbsent('#', new Trie());
        }
    }

    /**
     * leetcode: 字典树 Trie Tree
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie(dictionary);
        String[] split = sentence.split(" ");
        for(int i = 0; i < split.length; i++){
            split[i] = findRoot(split[i], trie);
        }
        return String.join(" ",split);
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

    /**
     * leetcode: 哈希集合
     * 首先将 dictionary 中所有词根放入哈希集合中，然后对于 sentence 中的每个单词，由短至长遍历它所有的前缀，如果这个前缀出现在哈希集合中，
     * 则我们找到了当前单词的最短词根，将这个词根替换原来的单词。最后返回重新拼接的句子。
     */
    public String replaceWords2(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        set.addAll(dictionary);
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            for (int j = 1; j <= split[i].length(); j++) {
                if (set.contains(split[i].substring(0, j))) {
                    split[i] = split[i].substring(0, j);
                    break;
                }
            }
        }
        return String.join(" ", split);
    }

    /**
     * 暴力匹配
     */
    public String replaceWords1(List<String> dictionary, String sentence) {
        String[] split = sentence.split(" ");
        //按字符长度排序，减少比较
        dictionary.sort(Comparator.comparingInt(String::length));
        for (int i = 0; i < split.length; i++) {
            for (var root : dictionary) {
                if (split[i].startsWith(root)) {
                    split[i] = root;
                    break;
                }
            }
        }
        return String.join(" ", split);
    }

    public static void main(String[] args) {
        codeofli.my.solution_template.data_structure.Trie replaceWords648 = new codeofli.my.solution_template.data_structure.Trie();

        System.out.println(replaceWords648.replaceWords(StringTransformUtil.toStringArrayList("[\"cat\",\"bat\",\"rat\"]"),
                "the cattle was rattled by the battery"));
        System.out.println(replaceWords648.replaceWords(StringTransformUtil.toStringArrayList("[\"cat\",\"bat\",\"rat\"]"),
                "the cattle was rattled by the battery").equals("the cat was rat by the bat"));

        System.out.println(replaceWords648.replaceWords(StringTransformUtil.toStringArrayList(" [\"a\",\"b\",\"c\"]"),
                "aadsfasf absbs bbab cadsfafs"));
        System.out.println(replaceWords648.replaceWords(StringTransformUtil.toStringArrayList("[\"a\",\"b\",\"c\"]"),
                "aadsfasf absbs bbab cadsfafs").equals("a a b c"));
    }
}

package com.lmz.leetcode.practice.other.easy.old;

public class IsPrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // <= sentence.length <= 100
        String[] split = sentence.split(" ");
        int cnt = 1;
        for(String s :split){
            if (s.startsWith(searchWord)) {
                return cnt;
            }
            cnt++;
        }
        return -1;
    }
}

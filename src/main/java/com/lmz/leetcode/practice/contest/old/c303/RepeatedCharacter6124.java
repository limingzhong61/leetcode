package com.lmz.leetcode.practice.contest.old.c303;

public class RepeatedCharacter6124 {
    public char repeatedCharacter(String s) {
    //    2 <= s.length <= 100
        int[] map = new int[26];
        for(char c : s.toCharArray()){
            map[c - 'a']++;
            if(map[c-'a'] == 2){
                return c;
            }
        }
        return ' ';
    }
}

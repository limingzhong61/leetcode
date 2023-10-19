package com.lmz.leetcode.practice.other.old.everyday;

import java.util.HashMap;

public class IsAlienSorted953 {
    /**
     * 使用HashMap
     */
    HashMap<Character, Integer> map = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        char[] chars = order.toCharArray();
        for(int i = 0; i <chars.length ; i++){
            map.put(chars[i],i);
        }
        for(int i = 1; i < words.length; i++){
            if(!isAscend(words[i-1],words[i])){
                return false;
            }
        }
        return true;
    }

    private boolean isAscend(String s1, String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int minLength = Math.min(chars1.length,chars2.length);

        for(int i = 0; i <  minLength; i++){
            if(map.get(chars1[i]) > map.get(chars2[i])){
                return false;
            }else if(map.get(chars1[i]) < map.get(chars2[i])){
                return true;
            }
        }
        if(s1.length() > s2.length()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsAlienSorted953 isAlienSorted953 = new IsAlienSorted953();
        System.out.println(isAlienSorted953.isAlienSorted(
                new String[]{"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted953.isAlienSorted(
                new String[]{"word","world","row"},"worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted953.isAlienSorted(
                new String[]{"apple","app"},"abcdefghijklmnopqrstuvwxyz"));
    }

}

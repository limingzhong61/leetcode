package com.lmz.leetcode.practice.p.easy.old;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: codeofli
 * @create: 2022-11-08 9:47
 */
public class CountConsistentStrings1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(var c : allowed.toCharArray()){
            set.add(c);
        }
        int res = 0;
        for(var s : words){
            boolean success = true;
            for(var c : s.toCharArray()){
                if(!set.contains(c)){
                    success = false;
                }
            }
            if(success){
                res++;
            }
        }
        return res;
    }
}

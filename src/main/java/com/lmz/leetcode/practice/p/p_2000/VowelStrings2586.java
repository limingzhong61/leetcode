package com.lmz.leetcode.practice.p.p_2000;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: limingzhong
 * @create: 2023-11-07 14:35
 * @description:
 */
public class VowelStrings2586 {
    class Solution {
        public int vowelStrings(String[] words, int left, int right) {
            Set<Character> set= Set.of('a','e','i','o','u');
            int cnt = 0;
            for(int i = left; i <= right; i++){
                if(set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length()-1))){
                    cnt++;
                }
            }
            return cnt;
        }
    }
}

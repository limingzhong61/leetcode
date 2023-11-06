package com.lmz.leetcode.practice.p.p_0_1000;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: limingzhong
 * @create: 2023-11-06 10:43
 * @description:
 */
public class MaxProduct318 {
    class Solution {
        public int maxProduct(String[] words) {
            int ans = 0;
            for(int i = 0; i < words.length; i++){
                HashSet<Character> set = new HashSet<>();
                for (char c : words[i].toCharArray()) {
                    set.add(c);
                }

                for(int j = i + 1; j < words.length; j++){
                    boolean dup = false;
                    for (char c : words[j].toCharArray()) {

                        if(set.contains(c)){
                            dup = true;
                            break;
                        }
                    }
                    if(!dup){
                        ans = Math.max(ans, words[i].length() * words[j].length());
                    }
                }
            }
            return ans;
        }
    }
}

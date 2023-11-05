package com.lmz.leetcode.practice.p.p_0_1000;

import test.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-11-05 19:23
 * @description:
 */
public class FindRepeatedDnaSequences187 {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            HashMap<String,Integer> map = new HashMap<>();
            List<String> ans = new ArrayList<>();

            for(int i = 0; i + 10 <= s.length(); i++){
                String sub = s.substring(i,i + 10);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
                if(map.get(sub) == 2){
                    ans.add(sub);
                }
            }
            return ans;
        }
    }
}

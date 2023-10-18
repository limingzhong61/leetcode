package com.lmz.algorithm_practice.other.easy;

import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-04-29 12:36
 */
public class EqualFrequency2423 {
    class Solution {
        public boolean equalFrequency(String word) {
            int[] counter = new int[26];
            int total = word.length(), letterLen = 26;
            for (var c : word.toCharArray()) {
                counter[c - 'a']++;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < letterLen; i++) {
                if (counter[i] > 0) {
                    map.put(counter[i], map.getOrDefault(counter[i], 0) + 1);
                }
            }
            //3个不同值，减1肯定不行
            if(map.size() > 3) return  false;
            int minF = 101,minCnt = 0,maxF = 0,maxCnt = 0;
            for(var entry : map.entrySet()){
                if(entry.getKey() <minF){
                    minF = entry.getKey();
                    minCnt = entry.getValue();
                }
                if(entry.getKey() > maxF){
                    maxF = entry.getKey();
                    maxCnt = entry.getValue();
                }
            }
            System.out.printf("%d,%d,%d\n",maxF,minF,maxCnt);
            // "abbcc"
            return minF == 1 && minCnt == 1 ||maxF - minF == 1 && maxCnt == 1 || maxF == minF && maxF == 1;
        }
    }
}

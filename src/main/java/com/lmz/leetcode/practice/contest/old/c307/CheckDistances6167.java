package com.lmz.leetcode.practice.contest.old.c307;

import java.util.HashMap;
import java.util.Map;

public class CheckDistances6167 {
    /**
     * hash
     */
    public boolean checkDistances(String s, int[] distance) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            if (map.containsKey(charIdx)) {
                map.put(charIdx, i - map.get(charIdx) -1);
            } else {
                map.put(charIdx, i);
            }
        }
        for (int i = 0; i < distance.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) != distance[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}

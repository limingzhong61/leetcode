package com.lmz.leetcode.practice.p.p_2000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-08-08 11:44
 */
public class UniqueOccurrences1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : arr){
            map.put(x,map.getOrDefault(x,0) +1);
        }
        return new HashSet<>(map.values()).size() == map.size();
    }
}

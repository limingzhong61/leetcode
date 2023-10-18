package com.lmz.algorithm_practice.other.medium.old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramsII033 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            var record = new int[26];
            for (char c : str.toCharArray()) {
                record[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int x : record) {
                sb.append(x).append('-');
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            map.put(sb.toString(), list);
        }
        return new ArrayList<>(map.values());
    }
}

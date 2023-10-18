package com.lmz.algorithm_practice.hash;

import java.util.*;

public class GroupAnagrams49 {
    /**
     * 计数
     * 由于字符串只包含小写字母，因此对于每个字符串，可以使用长度为 2626 的数组记录每个字母出现的次数。
     * java不能直接对数组重写hashcode方法，将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        List<List<String>> res = new ArrayList<>();
        for(String s : strs){
            int[] charCnt = new int[26];
            for(char c : s.toCharArray()){
                charCnt[c-'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (charCnt[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(charCnt[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            map.put(key, list);
        }
        return  res;
    }

    /**
     * 排序+hash
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return  new ArrayList(map.values());
    }
}

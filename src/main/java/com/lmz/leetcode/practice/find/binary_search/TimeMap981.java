package com.lmz.leetcode.practice.find.binary_search;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: codeofli
 * @create: 2022-10-25 14:17
 */
public class TimeMap981 {
    class TimeMap {
        HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();

        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
            treeMap.put(timestamp,value);
            map.put(key,treeMap);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> treeMap = map.get(key);
            if(treeMap == null){
                return "";
            }
            Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
            if(entry == null){
                return "";
            }
            return entry.getValue();
        }
    }
}

package com.lmz.leetcode.practice.other.medium.old;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarray {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        // cnt,loc
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cnt = 0;
        int maxLen = 0;
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            String s = array[i];
            if (Character.isDigit(s.charAt(0))) {
                cnt++;
            } else {
                cnt--;
            }
            if (map.containsKey(cnt)) {
                int len = i - map.get(cnt);
                System.out.printf("%d,%d,%d\n", len, map.get(cnt), i);
                if (maxLen < len) {
                    start = map.get(cnt);
                    end = i;
                }
            } else {
                map.put(cnt, i);
            }
        }
        return Arrays.copyOfRange(array, start + 1, end + 1);
    }
}

package com.lmz.leetcode.practice.two_pointer.same_direction_aka_slide_window;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-01-06 15:43
 */
public class findAnagramsII015 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()){
            return res;
        }
        int[] counter = new int[26];
        for (char c : p.toCharArray()) {
            counter[c - 'a']--;
        }
        int len = p.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            counter[cs[i] - 'a']++;
        }
        if (check(counter)) {
            res.add(0);
        }
        for (int i = len; i < s.length(); i++) {
            counter[cs[i - len] - 'a']--;
            counter[cs[i] - 'a']++;
            if (check(counter)) {
                res.add(i - len + 1);
            }
        }
        return res;
    }

    private boolean check(int[] counter) {
        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}

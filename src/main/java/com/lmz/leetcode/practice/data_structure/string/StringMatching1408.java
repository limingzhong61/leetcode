package com.lmz.leetcode.practice.data_structure.string;

import java.util.*;

public class StringMatching1408 {
    /**
     * 暴力枚举
     */
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    if(words[j].contains(words[i])){
                        res.add(words[i]);
                    }
                }
            }
        }
        return res;
    }
}

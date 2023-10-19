package com.lmz.leetcode.practice.sort.multi_key_sort;

import java.util.ArrayList;
import java.util.List;

public class FrequencySort451 {
    //    s 由大小写英文字母和数字组成
    public String frequencySort(String s) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            if (map[i] != 0) {
                list.add(new Pair((char) i, map[i]));
            }
        }
        list.sort((a, b) -> b.frequency - a.frequency);
        StringBuilder sb = new StringBuilder();
        for (Pair pair : list) {
            sb.append(String.valueOf(pair.c).repeat(pair.frequency));
        }
        return sb.toString();
    }

    class Pair {
        char c;
        int frequency;

        Pair(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }
    }
}

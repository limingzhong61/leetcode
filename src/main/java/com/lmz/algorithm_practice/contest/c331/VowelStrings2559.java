package com.lmz.algorithm_practice.contest.c331;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: limingzhong
 * @create: 2023-02-05 10:40
 */
public class VowelStrings2559 {
    /**
     * 前缀和
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int n = words.length;
        // f[i]表示[0,i)有多少个
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (set.contains(words[i-1].charAt(0)) && set.contains(words[i-1].charAt(words[i-1].length() - 1))) {
                f[i] = f[i - 1] + 1;
            } else {
                f[i] = f[i - 1];
            }
        }
        int[] res = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            res[i] = f[query[1] + 1] - f[query[0]];
        }
        return res;
    }

}

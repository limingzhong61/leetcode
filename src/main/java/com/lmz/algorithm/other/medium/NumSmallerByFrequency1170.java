package com.lmz.algorithm.other.medium;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-06-10 10:25
 */
public class NumSmallerByFrequency1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = f(queries);
        int[] w = f(words);
        Arrays.sort(words);
        int[] ans = new int[q.length];
        int idx = 0;
        for (int x : q) {
            for (int i = w.length - 1; i >= 0; i--) {
                if (x < w[i]) {
                   q[idx]++;
                }else{
                    break;
                }
            }
            idx++;
        }
        return ans;
    }

    private static int[] f(String[] queries) {
        int[] q = new int[queries.length];
        int idx = 0;
        for (var query : queries) {
            char[] cs = query.toCharArray();
            Arrays.sort(cs);
            int cnt = 0;
            char startChar = cs[0];
            for (int i = 0; i < cs.length; i++) {
                if (startChar == cs[i]) {
                    cnt++;
                } else {
                    break;
                }
            }
            q[idx++] = cnt;
        }
        return q;
    }
}

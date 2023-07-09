package com.lmz.algorithm.contest.c334;

/**
 * @author: limingzhong
 * @create: 2023-02-26 10:37
 */
public class DivisibilityArray {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        long num = 0;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            num = (word.charAt(i) - '0') + num * 10;
            if (num >= m || num == 0) {
                if (num % m == 0) {
                    res[i] = 1;
                }
                num %= m;
                //num = num - (long) (m) * (num/ m - 1);
            }
        }
        return res;
    }
}

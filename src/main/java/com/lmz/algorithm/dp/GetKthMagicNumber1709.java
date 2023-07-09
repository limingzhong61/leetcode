package com.lmz.algorithm.dp;

public class GetKthMagicNumber1709 {
    /**
     * 数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
     */
    public int getKthMagicNumber(int k) {
        int a = 3, b = 5, c = 7;
        int[] f = new int[k + 1];
        f[1] = 1;
        int startA = 1;
        int startB = 1;
        int startC = 1;

        for (int i = 2; i <= k; i++) {
            int nextA = f[startA] * a;
            int nextB = f[startB] * b;
            int nextC = f[startC] * c;
            int min = Math.min(nextA, Math.min(nextB, nextC));
            if (min % f[startA] == 0) {
                startA++;
            }
            if (min % f[startB] == 0) {
                startB++;
            }
            if (min % f[startC] == 0) {
                startC++;
            }
            f[i] = min;
        }
        return f[k];
    }
}

package com.lmz.leetcode.practice.p.easy.old;

public class MinimumRecolors2379 {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int[] bSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bSum[i] = bSum[i - 1];
            if (blocks.charAt(i - 1) == 'B') {
                bSum[i]++;
            }
        }
        int minNeed = n;
        for (int i = k; i <= n; i++) {
            int needCnt = k - (bSum[i] - bSum[i - k]);
            minNeed = Math.min(minNeed, needCnt);
        }
        return minNeed;
    }
}

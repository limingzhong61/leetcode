package com.lmz.leetcode.practice.other.easy.old;

/**
 * @author: codeofli
 * @create: 2022-11-15 9:47
 */
public class MaximumUnits1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int count = 0;
        int[] ans = new int[1001];
        for (int[] is : boxTypes) {
            ans[is[1]] += is[0];
        }
        for (int i = ans.length - 1; i > 0; i--) {
            if (ans[i] != 0) {
                if (truckSize > ans[i]) {
                    count += ans[i] * i;
                    truckSize -= ans[i];
                } else {
                    return count + truckSize * i;
                }
            }
        }
        return count;
    }
}

package com.lmz.leetcode.practice.p.old.intro.array;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class MaxProfit714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] f= new int[n][2];
        f[0][0] = -prices[0];
        f[0][1] = 0;
        for(int i = 1; i < n; i++){
            f[i][0] = Math.max(f[i-1][0],f[i-1][1] -prices[i]);
            f[i][1] = Math.max(f[i-1][1],f[i-1][0] +prices[i] -fee);
        }
        return  f[n-1][1];
    }

    public static void main(String[] args) {
        MaxProfit714 maxProfit714 = new MaxProfit714();
        System.out.println(maxProfit714.maxProfit(TransformUtil.toIntArray("[1, 3, 2, 8, 4, 9]"), 2));
        System.out.println(maxProfit714.maxProfit(TransformUtil.toIntArray("[1, 3, 2, 8, 4, 9]"), 2) == 8);

        System.out.println(maxProfit714.maxProfit(TransformUtil.toIntArray("[1,3,7,5,10,3]"), 3));
        System.out.println(maxProfit714.maxProfit(TransformUtil.toIntArray("[1,3,7,5,10,3]"), 3) == 6);

    }
}

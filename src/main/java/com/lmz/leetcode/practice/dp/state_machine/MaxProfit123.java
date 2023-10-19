package com.lmz.leetcode.practice.dp.state_machine;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

/**
 * @author: limingzhong
 * @create: 2023-10-03 14:08
 * @description:
 */
public class MaxProfit123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 第i天持有股票的交易j次的maxProfit
        int[][] f = new int[n][3];

        // 第i天未持有股票的交易j次的maxProfit
        int[][] f2 = new int[n][3];
        int ans = 0;
        //for(int i = 1; i < n; i++){
        //    f[i][1] = f[i][2] = Integer.MIN_VALUE;
        //    f2[i][0] =  f2[i][1] = f2[i][2] = Integer.MIN_VALUE;
        //}
        f[0][1] = -prices[0];
        // 交易两次包含了一次
        f[0][2] = -prices[0];

        for(int i = 1; i < n; i++){
            for(int j = 1; j <= 2; j++){
                f[i][j] = Math.max(f[i-1][j], f2[i-1][j-1] - prices[i]);

                f2[i][j] = Math.max(f2[i-1][j], f[i-1][j] + prices[i]);

                ans = Math.max(ans,f2[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProfit123 maxProfit123 = new MaxProfit123();
        testCase(maxProfit123, "[1,2,3,4,5]", 4);
        testCase(maxProfit123, "[3,3,5,0,0,3,1,4]", 6);

    }

    private static void testCase(MaxProfit123 maxProfit123, String original, int x) {
        System.out.println(maxProfit123.maxProfit(TransformUtil.toIntArray(original)));
        System.out.println(maxProfit123.maxProfit(TransformUtil.toIntArray(original)) == x);
    }
}

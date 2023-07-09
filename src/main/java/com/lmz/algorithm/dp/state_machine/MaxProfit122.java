package com.lmz.algorithm.dp.state_machine;

import com.lmz.my.leetcode.TransformUtil;

public class MaxProfit122 {
    /**
     dp: f[i] 表示i天结束，未持有股票的最大利润
     f2[i] 表示i天结束，持有股票的最大利润

     在任何时候 最多 只能持有 一股 股票
     每一天，你可以决定是否购买和/或出售股票
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] f = new int[n],f2 = new int[n];
        f[0] = 0;
        f2[0] = -prices[0];
        for(int i = 1; i < n; i++){
            f[i] = Math.max(f[i-1],f2[i-1] + prices[i]);
            f2[i] = Math.max(f2[i-1],f[i-1] - prices[i]);
        }
        return f[n-1];
    }



    public int maxProfit4(int[] prices) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }

        return dp0;
    }

    /**
     * 利用贪心算法，要想利润最大，则每次卖出都必须是正的。
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProfit122 maxProfit122 = new MaxProfit122();
        System.out.println(maxProfit122.maxProfit(TransformUtil.toIntArray("[7,1,5,3,6,4]")));
    }
}

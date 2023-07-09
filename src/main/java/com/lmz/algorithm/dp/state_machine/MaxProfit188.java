package com.lmz.algorithm.dp.state_machine;

/**
 * @author: limingzhong
 * @create: 2023-06-30 11:54
 * 188.买卖股票的最佳时机IⅣ(至多交易k 次)
 *
 * 定义dfs(i,j,0）表示到第i天结束时完成至多j笔交易，未持有股票的最大利润
 *
 * 定义dfs(i,j,1)表示到第i天结束时完成至多j笔交易，持有股票的最大利润
 */
public class MaxProfit188 {
    /**
     *定义dfs(i,j,0）表示到第i天结束时完成至多j笔交易，未持有股票的最大利润
     *定义dfs(i,j,1)表示到第i天结束时完成至多j笔交易，持有股票的最大利润
     * 只有在买入时增加交易次数
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] f = new int[n][k+1][2];
        f[0][0][0] = 0;
        f[0][1][1] = -prices[0];
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= k; j++){
                f[i][j][0] = Math.max(f[i-1][j][0],f[i-1][j][1] + prices[i]);
                f[i][j][1] = Math.max(f[i-1][j][1],f[i-1][j-1][1] + prices[i]);
            }
        }
        return f[n-1][k][0];
    }
}

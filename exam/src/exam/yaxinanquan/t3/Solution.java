package exam.yaxinanquan.t3;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param prices int整型一维数组 金条的每天价格数组 prices，其中prices[i]是第i天的价格
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // write code here
        int n = prices.length;
        int[][][] f = new int[n][3][2];
        f[0][1][0] = -prices[0];
        f[0][1][1] = 0;
        int ans = 0;
        for(int i = 1; i < n; i++){
            f[i][1][0] = Math.max(f[i-1][1][0], - prices[i]);
            f[i][1][1] = Math.max(f[i-1][1][1], f[i-1][1][0] + prices[i]);

            f[i][2][0] = Math.max(f[i-1][2][0], f[i-1][1][1] - prices[i]);
            f[i][2][1] = Math.max(f[i-1][2][1], f[i-1][2][0] + prices[i]);
            ans = Math.max(ans, Math.max(f[i][1][1], f[i][2][1]));
        }
        return ans;
    }
}
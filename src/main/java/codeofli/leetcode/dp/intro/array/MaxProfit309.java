package codeofli.leetcode.dp.intro.array;

import codeofli.my.leetcode.TransformUtil;

public class MaxProfit309 {

    /**
     *
     * 我们用f[i] 表示第 i 天结束之后的「累计最大收益」。根据题目描述，由于我们最多只能同时买入（持有）一支股票，
     * 并且卖出股票后有冷冻期的限制，因此我们会有三种不同的状态：
     * 我们目前持有一支股票，对应的「累计最大收益」记为 `f[i][0]`；
     * 我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 `f[i][1]`；
     * 我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 `f[i][2]`。（多加一种状态）
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        f[0][1] = 0;
        f[0][2] = 0;
        for(int i = 1; i < n; i++){
            f[i][0] = Math.max(f[i-1][2]-prices[i],f[i-1][0]);
            f[i][1] = f[i-1][0]+prices[i]; //冷静期必须买入
            f[i][2] = Math.max(f[i-1][2],f[i-1][1]); //非冷静期不能买入
        }
        return Math.max(f[n-1][1],f[n-1][2]);
    }

    public static void main(String[] args) {
        MaxProfit309 maxProfit309 = new MaxProfit309();
        System.out.println(maxProfit309.maxProfit(TransformUtil.toIntArray("[1,2,3,0,2]")));
        System.out.println(maxProfit309.maxProfit(TransformUtil.toIntArray("[1,2,3,0,2]")) == 3 );
    }
}

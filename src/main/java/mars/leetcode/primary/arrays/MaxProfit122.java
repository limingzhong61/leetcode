package mars.leetcode.primary.arrays;

public class MaxProfit122 {
    /**
     * mySolution:
     * //maxProfits[i] 表示当前阶段的最大利润
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        //maxProfits[i] 表示当前阶段的最大利润
        int size = prices.length;
        int[] maxProfits = new int[size];
        maxProfits[0] = 0; //第一天,没法交易,收益为0
        for (int i = 1; i < size; i++) {
            //(0,i)一次操作的利润是否更大
            maxProfits[i] = Math.max(maxProfits[i], prices[i] - prices[0]);
            for (int j = 1; j < i; j++) { //卖出交易
                //(0,j-1)(j,i)的利润（不能同时交易，只能隔天交易）
                maxProfits[i] = Math.max(prices[i] - prices[j] + maxProfits[j - 1],
                        maxProfits[i]);
            }
            //for(int j = 0; j <= i; j++){
            //    System.out.print(maxProfits[j] +",");
            //}
            //System.out.println();
            //可能以前的利润更大
            maxProfits[i] = Math.max(maxProfits[i], maxProfits[i - 1]);
        }
        return maxProfits[size - 1];
    }

    /**
     * 动态规划
     * 定义状态 dp[i][0] 表示第 ii 天交易完后手里没有股票的最大利润，
     * dp[i][1] 表示第 ii 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
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
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}

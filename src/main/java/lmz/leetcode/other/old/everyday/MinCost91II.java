package lmz.leetcode.other.old.everyday;

public class MinCost91II {
    /**
     * dp[i][j]表示i房间选择j号颜色的最小值
     * dp[i][j] = min(dp[i-1][k]+costs[i][j]),其中k!=j
     */
    public int minCost(int[][] costs) {

        int len = costs.length, colorCnt = costs[0].length;
        int[][] dp = new int[len][colorCnt];
        for (int i = 0; i < colorCnt; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < colorCnt; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < colorCnt; k++) {
                    if (k != j) {
                        dp[i][j] = Math.min(dp[i - 1][k] + costs[i][j], dp[i][j]);
                    }

                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < colorCnt; i++) {
            minCost = Math.min(dp[len - 1][i], minCost);
        }
        return minCost;
    }
}

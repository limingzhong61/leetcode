package com.lmz.algorithm.other.old.dp;

public class NumWays10II {
    /**
     * dp: dp[i]表示有多少种跳法
     * 转移方程： dp[i] = dp[i-1] + dp[i-2];(dp[1] = dp[0] = 1)
     */
    public int numWays(int n) {
        final int MOD = 1000000007;
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumWays10II numWays10II = new NumWays10II();
        System.out.println(numWays10II.numWays(7));
        System.out.println(numWays10II.numWays(7) == 21);
        System.out.println(numWays10II.numWays(100));
        System.out.println(numWays10II.numWays(100) == 782204094);
    }
}

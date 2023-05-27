package lmz.algorithm.other.old.intro;

public class Change518 {
    /**
     * dp：背包问题求组合数，外层循环用可选数coins
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}

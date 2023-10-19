package com.lmz.leetcode.practice.other.old.dp;

import java.util.Arrays;

public class DicesProbability {
    /**
     * 正向递推:
     * 由于新增骰子的点数只可能为 1至 6，因此概率f(n−1,x) 仅与 f(n,x+1) , f(n,x+2), ... ,f(n,x+6) 相关。
     */
    public double[] dicesProbability1(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    /**
     dp:f[i][j] 表示第i次投掷骰子时，整个j的概率
     */
    public double[] dicesProbability(int n) {

        double[][] f = new double[n+1][];
        double base = 1.0 / 6;
        f[1] = new double[7];
        Arrays.fill(f[1],base);
        f[1][0] = 0;
        for(int i = 2; i <= n; i++){
            f[i] = new double[i*6+1];
            for(int j = i; j < f[i].length; j++){
                for(int k = 1; k <= 6; k++){
                    if(j - k >= 0 && j-k < f[i-1].length)
                        f[i][j] += f[i-1][j-k]* base;
                }
            }
        }
        // 第n次共有 [n,6*n]种可能，长度6*n-n+1
        double[] ans = new double[5*n+1];
        int idx = 0;
        for(int i= n; i <= 6*n; i++){
            ans[idx++] = f[n][i];
        }
        return ans;
    }
    public static void main(String[] args) {
        DicesProbability dicesProbability = new DicesProbability();
        //System.out.println(Arrays.toString(dicesProbability.dicesProbability(1)));
        System.out.println(Arrays.toString(dicesProbability.dicesProbability(3)));
    }
}

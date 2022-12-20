package lmz.leetcode.graph_parse_ds.dp;

import java.util.Arrays;

public class DicesProbability {
    /**
     * 正向递推
     * 由于新增骰子的点数只可能为 1至 6，因此概率f(n−1,x) 仅与 f(n,x+1) , f(n,x+2), ... ,f(n,x+6) 相关。
     */
    public double[] dicesProbability(int n) {
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
     * 模拟递推：
     */
    public double[] dicesProbability1(int n) {
        int maxValue = n * 6;
        //记录可能性个数
        int[] dp = new int[maxValue + 1];
        //只有一个骰子
        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;
        }
        for (int k = 2; k <= n; k++) {
            //倒着推，可以省略一个数组
            for (int i = k * 6; i >= k; i--) {
                //利用之前的数组，需要重置计算位为0，因为下面需要累加
                dp[i] = 0;
                for (int j = 1; j <= 6 && j <= i; j++) {
                    dp[i] += dp[i - j];
                }
                //利用之前的数组，需要重置计算位为0，因为下面需要累加
            }
            dp[k-1] = 0;
        }
        //计算概率
        double sum = Math.pow(6, n);
        double[] probabilities = new double[6 * n - n+1];
        int cnt = 0;
        for (int i = n; i <= 6 * n; i++) {
            probabilities[cnt++] = dp[i] / sum;
        }
        return probabilities;
    }

    public static void main(String[] args) {
        DicesProbability dicesProbability = new DicesProbability();
        //System.out.println(Arrays.toString(dicesProbability.dicesProbability(1)));
        System.out.println(Arrays.toString(dicesProbability.dicesProbability(3)));
    }
}

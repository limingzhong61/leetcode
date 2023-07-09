package com.lmz.algorithm.contest.c330;

/**
 * @author: limingzhong
 * @create: 2023-01-29 10:59
 */
public class MonkeyMove {
    /**
     * 找规律： 2^n-2;
     * @param n
     * @return
     */
    public int monkeyMove(int n) {
        long mod = (int) (1e9+7);
        long res = quickPow(2, (long) n, (int) mod);
        res  = (res + mod - 2) % mod;
        return (int)res;
    }

    /**
     * my:迭代-快速幂
     * 每个额外乘的x对应了 7 的二进制表示 (1001101)_2中的每个 1！
     * 注意：n不可以为负数
     */
    public long quickPow(long x, long pow,int mod) {
        long res = 1;
        // 贡献的初始值为 x
        long xContribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (pow != 0) {
            if (pow % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                res  = (res * xContribute) % mod;
            }
            xContribute = (xContribute * xContribute) % mod;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            pow /= 2;
        }
        return  res;
    }

    public static void main(String[] args) {
        MonkeyMove monkeyMove = new MonkeyMove();
        System.out.println(monkeyMove.monkeyMove(500000003));
    }
}

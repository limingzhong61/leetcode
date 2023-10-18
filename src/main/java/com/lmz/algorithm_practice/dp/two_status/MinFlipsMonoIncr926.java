package com.lmz.algorithm_practice.dp.two_status;

/**
 * @author: limingzhong
 * @create: 2023-03-31 21:17
 */
public class MinFlipsMonoIncr926 {
    /**
     * dp
     * zero[i] 表示 s[i]为0的最小翻转次数
     * one[i]  表示 s[i]为1的最小翻转次数
     */
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] zero = new int[n], one = new int[n];
        char[] cs = s.toCharArray();
        if (cs[0] == '0') {
            one[0] = 1;
        } else {
            zero[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (cs[i] == '0') {
                zero[i] = zero[i - 1];
                one[i] = Math.min(zero[i - 1], one[i - 1]) + 1;
            } else { // 1
                zero[i] = zero[i - 1] + 1;
                one[i] = Math.min(zero[i - 1], one[i - 1]);
            }
            System.out.printf("%d,%d\n",zero[i],one[i]);
        }
        return Math.min(zero[n - 1], one[n - 1]);
    }
}

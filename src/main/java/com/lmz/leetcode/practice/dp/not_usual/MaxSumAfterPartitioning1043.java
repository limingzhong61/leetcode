package com.lmz.leetcode.practice.dp.not_usual;

/**
 * @author: limingzhong
 * @create: 2023-04-19 10:47
 */
public class MaxSumAfterPartitioning1043 {
    class Solution {
        /**
         * dp分割数组
         * f[i]表示[0,i-1]的最大值
         */
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            var f = new int[n + 1];
            f[0] = 0;
            for (int i = 1; i <= n; i++) {
                int max = arr[i - 1];
                for (int j = i - 1; j >= i - k && j >= 0; j--) {
                    max = Math.max(arr[j], max);
                    f[i] = Math.max(f[i], f[j] + max * (i - j));
                }
            }
            return f[n];
        }
    }
}

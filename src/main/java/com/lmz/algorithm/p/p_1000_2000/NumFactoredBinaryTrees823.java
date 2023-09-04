package com.lmz.algorithm.p.p_1000_2000;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-08-29 21:22
 */
public class NumFactoredBinaryTrees823 {
    /**
     * dp 统计
     * f[i] 的含义表示根节点值为idx = i 时这个 arr[i]的二叉树的个数。
     */
    public int numFactoredBinaryTrees(int[] arr) {
        long ans = 0;
        int len = arr.length;
        HashMap<Integer, Integer> idx = new HashMap<>(len);
        // 记录arr[i]对于的idx
        for (int i = 0; i < len; i++) {
            idx.put(arr[i], i);
        }
        final long mod = 1000_000_000 + 7;
        Arrays.sort(arr);
        long[] f = new long[len];
        for (int i = 0; i < len; i++) {
            f[i] = 1;
            int val = arr[i];
            // 从0-i-1枚举
            for (int j = 0; j < i; j++) {

                if (val % arr[j] == 0 && idx.containsKey(val / arr[j])) {
                    long t = (f[j] * f[idx.get(val / arr[j])]) % mod;
                    f[i] = (f[i] + t) % mod;
                }
            }
            ans = (ans + f[i]) % mod;
        }
        return (int) ans;
    }
}

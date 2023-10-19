package com.lmz.leetcode.practice.p.p_2000;

/**
 * @author: limingzhong
 * @create: 2023-09-02 9:24
 */
public class CaptureForts2511 {
    /**
     * 题意： 输出 1到-1之间最大距离
     */
    public int captureForts(int[] forts) {
        int n = forts.length, ans = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1) {
                for (int j = i; j >= 0; j--) {
                    if (forts[j] == -1) {
                        ans = Math.max(ans, i - j - 1);
                        break;
                    }
                }
                for (int j = i; j < n; j++) {
                    if (forts[j] == -1) {
                        ans = Math.max(ans, j - i - 1);
                        break;
                    }
                }
            }

        }
        return ans;
    }
}

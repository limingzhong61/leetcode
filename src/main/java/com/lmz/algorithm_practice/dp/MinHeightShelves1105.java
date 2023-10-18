package com.lmz.algorithm_practice.dp;

/**
 * @author: limingzhong
 * @create: 2023-04-23 10:41
 */
public class MinHeightShelves1105 {
    class Solution {
        /**
         * dp: 定义f[n+1]原问题，f[i+1]表示0-i的最小高度
         */
        public int minHeightShelves(int[][] books, int shelfWidth) {
            int n = books.length;
            var f = new int[n + 1];// f[0]=0，翻译自 dfs(-1)=0
            for (int i = 0; i < n; i++) {
                int maxH = books[i][1];
                f[i + 1] = Integer.MAX_VALUE;
                for (int j = i, sumWidth = 0; j >= 0 ; j--) {
                    sumWidth += books[j][0];
                    if(sumWidth > shelfWidth) break;

                    maxH = Math.max(maxH, books[j][1]);
                    f[i + 1] = Math.min(f[i + 1], f[j] + maxH);

                }
            }
            return f[n];
        }
    }
}

package com.lmz.algorithm_practice.other.medium;

import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-05-15 11:22
 */
public class MaxEqualRowsAfterFlips1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans = 0, n = matrix[0].length;
        var cnt = new HashMap<String, Integer>();
        for (var row : matrix) {
            var r = new char[n];
            for (int j = 0; j < n; j++)
                r[j] = (char) (row[j] ^ row[0]); // 翻转第一个数为 1 的行
            int c = cnt.merge(new String(r), 1, Integer::sum);
            ans = Math.max(ans, c);
        }
        return ans;
    }
}

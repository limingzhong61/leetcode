package com.lmz.leetcode.practice.other.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-06-15 14:20
 */
public class CanMakePaliQueries1177 {
    /**
     * 可以创建 26个前缀和数组，分别统计每种字母。以字母 a\texttt{a}a 为例，在计算前缀和时，如果 s[i]=as[i]=\texttt{a}s[i]=a 就视作 111，否则视作 000。
     */
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int letterCnt = 26;
        int[][] sum = new int[n + 1][letterCnt];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1].clone();
            sum[i][cs[i - 1] - 'a']++;
        }
        //System.out.print(Arrays.deepToString(sum));
        List<Boolean> ans = new ArrayList<>();
        for (var query : queries) {
            int left = query[0], right = query[1], k = query[2], m = 0;
            for (int j = 0; j < 26; j++) {
                m += (sum[right + 1][j] - sum[left][j]) % 2; // 奇数+1，偶数+0
            }
            ans.add(m / 2 <= k);

        }
        return ans;
    }
}

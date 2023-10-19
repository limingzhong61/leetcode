package com.lmz.leetcode.practice.other.medium.old;

/**
 * @author: limingzhong
 * @create: 2023-01-12 21:31
 */
public class CountSubstringsII020 {
    public int countSubstrings(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        // [i,j]是否是回文串(i < j)
        boolean[][] f = new boolean[n][n];
        f[0][0] = true;
        for (int i = 1; i < n; i++) {
            f[i][i] = true;
            if (cs[i] == cs[i - 1]) {
                f[i - 1][i] = true;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (cs[i] == cs[j] && cs[i + 1] == cs[j - 1]) {
                    f[i][j] = true;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for(int j = i; j < n; j++){
                if(f[i][j]){
                    cnt++;
                    System.out.printf("%d,%d\n",i,j);
                }
            }
        }
        return cnt;
    }
}

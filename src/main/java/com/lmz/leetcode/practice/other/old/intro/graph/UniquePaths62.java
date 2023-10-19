package com.lmz.leetcode.practice.other.old.intro.graph;

public class UniquePaths62 {
    /**
     * leetcode:组合数学
     * 机器人一定会走m+n-2步，即从m+n-2中挑出m-1步向下走不就行了吗？即C（（m+n-2），（m-1））。
     * 1 <= m, n <= 100
     */
    public int uniquePaths(int m, int n) {
        long res = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            System.out.printf("%d,%d",x,y);
            res = x * res / y;
        }
        return (int) res;
    }

    /**
     * dp: f[i][j]表示到达i,j的不同路径
     */
    public int uniquePaths1(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] += f[i - 1][j] + f[j - 1][i];
            }
        }
        return f[m - 1][n - 1];
    }
}

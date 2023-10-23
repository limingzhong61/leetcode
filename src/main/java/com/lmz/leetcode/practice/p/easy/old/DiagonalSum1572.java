package com.lmz.leetcode.practice.p.easy.old;

public class DiagonalSum1572 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += mat[i][i];
        }
        for (int i = 0; i < n; i++) {
            res += mat[i][i];
            res += mat[i][n - i - 1];
        }
        return  n % 2 == 0 ? res : res - mat[n/2][n/2];
    }
}

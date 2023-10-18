package com.lmz.algorithm_practice.simulation;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class FindRotation1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        //n == mat.length == target.length
        //n == mat[i].length == target[i].length
        //0°
        if (equals(mat, target)) {
            return true;
        }
        //最多旋转3次
        for (int i = 0; i < 3; i++) {
            tran(mat);
            if (equals(mat, target)) {
                return true;
            }
        }
        return false;
    }

    // 90度， 翻转+对角线= 90°
    void tran(int mat[][]) {
        int n = mat.length;
        // 180度
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = mat[n - i - 1][j];
                mat[n - i - 1][j] = mat[i][j];
                mat[i][j] = temp;
            }
        }
        //对角线
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[j][i];
                mat[j][i] = mat[i][j];
                mat[i][j] = temp;
            }
        }
    }

    boolean equals(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindRotation1886 findRotation1886 = new FindRotation1886();
        System.out.println(findRotation1886.findRotation(TransformUtil.toIntMatrix("[[0,1],[1,0]]"), TransformUtil.toIntMatrix("[[1,0],[0,1]]")));
    }
}

package com.lmz.leetcode.practice.p.old.intro.graph;

public class MinFallingPathSum931 {
    /**
     * f[i,j]表示到达（i,j)的最小和
     */
    public int minFallingPathSum(int[][] a) {
        //n == matrix.length == matrix[i].length
        //1 <= n <= 100
        int n = a.length;
        int[][] f= new int[n][n];
        for(int i = 0; i < n; i++){
            f[0][i] = a[0][i];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int min = f[i-1][j];
                if(j-1 >= 0){
                    min = Math.min(min,f[i-1][j-1]);
                }
                if(j+1 < n){
                    min = Math.min(min,f[i-1][j+1]);
                }
                f[i][j] +=  a[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i : f[n-1]){
            res = Math.min(res,i);
        }
        return res;
    }
}

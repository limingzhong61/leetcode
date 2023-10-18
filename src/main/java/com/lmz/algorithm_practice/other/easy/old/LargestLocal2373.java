package com.lmz.algorithm_practice.other.easy.old;

/**
 * @author: limingzhong
 * @create: 2023-03-01 8:45
 */
public class LargestLocal2373 {
    public int[][] largestLocal(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m-2][n-2];
        for(int i = 0; i + 2 < m; i++){
            for(int j = 0; j + 2 < n; j++){
                int max = Integer.MIN_VALUE;
                for(int a = 0; a < 3; a++){
                    for(int b = 0; b < 3; b++){
                        max = Math.max(max,grid[b + i][b + j]);
                    }
                }
                res[i][j] = max;
            }
        }
        return res;
    }
}

package com.lmz.leetcode.practice.p.p_1000_2000;

/**
 * @author: limingzhong
 * @create: 2023-08-24 10:16
 * @description:
 */
public class CountServers1267 {
    public int countServers(int[][] grid) {
        // m * n
        int m = grid.length,n = grid[0].length;
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                 if(grid[i][j] == 1){
                     boolean success = false;
                     for(int k = 0; k < m; k++){
                         if(k != i && grid[k][j] == 1){
                             cnt++;
                             success = true;
                             break;
                         }
                     }
                     if(success) continue;

                     for(int k = 0; k < n; k++){
                         if(k != j && grid[i][k] == 1){
                             cnt++;
                             break;
                         }
                     }
                 }
            }
        }
        return cnt;
    }
}

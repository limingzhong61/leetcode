package com.lmz.leetcode.practice.p.p_2000;

import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-09-13 9:13
 */
public class CheckValidGrid2596 {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(grid[i][j], new int[]{i, j});
            }
        }
        int[] loc = map.get(0);
        int x = loc[0],y = loc[1];
        for (int i = 0; i < n * n; i++) {
            loc = map.get(i);
            int nextX = loc[0],nextY = loc[1];
            int disX = Math.abs(x - nextX),dixY = Math.abs(y - nextY);
            if(disX == 1 && dixY == 2 || disX == 2 && dixY == 1){
                continue;
            }else{
                System.out.println(nextX);
                System.out.println(nextY);
                return  false;
            }
        }
        return true;
    }
}

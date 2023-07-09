package com.lmz.algorithm.graph;

import com.lmz.my.leetcode.TransformUtil;

import java.util.LinkedList;
import java.util.Queue;

public class CountSubIslands1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int cnt = 0;
        int m = grid1.length, n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 1) {
                    cnt += bfs(i, j, grid2, grid1);
                }
            }
        }
        return cnt;
    }


    public int bfs(int i, int j, int[][] grid2, int[][] grid1) {
        //右下左上（顺时针）移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int m = grid1.length, n = grid1[0].length;
        grid2[i][j] = 2; //标记访问
        grid1[i][j] = 2;
        int success = 1;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nextX = point[0] + next[k][0];
                int nextY = point[1] + next[k][1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && grid2[nextX][nextY] == 1) {
                    if (grid1[nextX][nextY] != 1) {
                        success = 0;
                    }
                    grid2[nextX][nextY] = 2; //标记访问
                    grid1[nextX][nextY] = 2;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return success;
    }

    public static void main(String[] args) {
        CountSubIslands1905 countSubIslands1905 = new CountSubIslands1905();
        System.out.println(countSubIslands1905.countSubIslands(TransformUtil.
                        toIntMatrix("[[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]"),
                TransformUtil.toIntMatrix(
                        "[[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]")));
    }
}

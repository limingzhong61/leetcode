package com.lmz.util.solution_template.graph.map;

import com.lmz.leetcode.practice.graph.MaxAreaOfIsland695;
import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.LinkedList;
import java.util.Queue;

public class MapBFSByMove {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    /**
     * 地图 ： 上下左右移动版
     *
     * @param x
     * @param y
     * @param grid 地图
     * @return
     */
    public int bfs(int[][] grid, int x, int y) {
        int cnt = 0;
        //右下左上（顺时针）移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int m = grid.length, n = grid[0].length;
        grid[x][y] = 2; //标记访问
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            x = point[0];
            y = point[1];
            cnt++;
            for (int[] item : next) {
                int nextX = x + item[0];
                int nextY = y + item[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && grid[nextX][nextY] == 1) {
                    grid[nextX][nextY] = 2; //标记访问
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        //int[][] ints = new int[1][0];
        //System.out.println(ints.length);
        //System.out.println(ints[0][0]);
        MaxAreaOfIsland695 maxAreaOfIsland695 = new MaxAreaOfIsland695();
        System.out.println(maxAreaOfIsland695.maxAreaOfIsland
                (TransformUtil.toIntMatrix("[[0,0,1,0,0,0,0,1,0,0,0,0,0]," +
                        "[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0]," +
                        "[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0]," +
                        "[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0]," +
                        "[0,0,0,0,0,0,0,1,1,0,0,0,0]]\n")));
        System.out.println(maxAreaOfIsland695.maxAreaOfIsland
                (TransformUtil.toIntMatrix("[[0,0,1,0,0,0,0,1,0,0,0,0,0]," +
                        "[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0]," +
                        "[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0]," +
                        "[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0]," +
                        "[0,0,0,0,0,0,0,1,1,0,0,0,0]]\n")) == 6);

        System.out.println(maxAreaOfIsland695.maxAreaOfIsland
                (TransformUtil.toIntMatrix("[[0,0,0,0,0,0,0,0]]")));
        System.out.println(maxAreaOfIsland695.maxAreaOfIsland
                (TransformUtil.toIntMatrix("[[0,0,0,0,0,0,0,0]]")) == 0);
    }
}

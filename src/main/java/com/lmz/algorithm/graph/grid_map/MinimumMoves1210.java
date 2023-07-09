package com.lmz.algorithm.graph.grid_map;

import com.lmz.my.leetcode.TransformUtil;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: limingzhong
 * @create: 2023-02-05 10:02
 */
public class MinimumMoves1210 {
    public int minimumMoves(int[][] grid) {
        //    2 <= n <= 100;n*n
        int n = grid.length;
        //x,y,方向，移动次数    0向右，1向下 ,其中x,y是头
        final int rightDir = 0, downDir = 1;
        boolean[][][] visited = new boolean[n][n][2];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{0, 1, 0, 0});
        visited[0][1][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], dir = poll[2];
            if (x == n - 1 && y == n - 1 && dir == rightDir) {
                return poll[3];
            }


            int nextX = x + 1,nextY = y+1;
            // 选择判断
            if (dir == 0) { //向右
                //右和下方向都可以走,并且走后身体方向不变

                //右走
                if (nextY < n && grid[x][nextY] == 0 && !visited[x][nextY][dir]) {
                    visited[x][nextY][dir] = true;
                    queue.add(new int[]{x, nextY, dir, poll[3] + 1});
                }
                // 下走，整个身体下移
                if (nextX < n && grid[nextX][y] == 0 && grid[nextX][y-1] == 0 && !visited[nextX][y][dir]) {
                    visited[nextX][y][dir] = true;
                    queue.add(new int[]{nextX, y, dir, poll[3] + 1});
                }

                //它处于水平状态并且其下面的两个单元都是空的，就顺时针旋转 90 度
                if (nextX < n && grid[nextX][y - 1] == 0 && grid[nextX][y] == 0 && !visited[nextX][y - 1][1]) {
                    visited[nextX][y - 1][1] = true;
                    queue.add(new int[]{nextX, y - 1, 1, poll[3] + 1});
                }
            } else { //向下
                //右和下方向都可以走,并且走后身体方向不变

                //右走,，整个身体右移
                if (nextY < n && grid[x][nextY] == 0 && grid[x-1][nextY] == 0 && !visited[x][nextY][dir]) {
                    visited[x][nextY][dir] = true;
                    queue.add(new int[]{x, nextY, dir, poll[3] + 1});
                }
                // 下走，整个身体下移
                if (nextX < n && grid[nextX][y] == 0 && !visited[nextX][y][dir]) {
                    visited[nextX][y][dir] = true;
                    queue.add(new int[]{nextX, y, dir, poll[3] + 1});
                }


                if (nextY < n && grid[x][nextY] == 0 && grid[x - 1][nextY] == 0 && !visited[x - 1][nextY][rightDir]) {
                    visited[x - 1][nextY][rightDir] = true;
                    queue.add(new int[]{x - 1, nextY, rightDir, poll[3] + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumMoves1210 minimumMoves1210 = new MinimumMoves1210();
        System.out.println(minimumMoves1210.minimumMoves(TransformUtil.toIntMatrix("[[0,0,0,0,0,1],\n" +
                "               [1,1,0,0,1,0],\n" +
                "               [0,0,0,0,1,1],\n" +
                "               [0,0,1,0,1,0],\n" +
                "               [0,1,1,0,0,0],\n" +
                "               [0,1,1,0,0,0]]")));
    }
}

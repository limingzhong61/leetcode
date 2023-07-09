package com.lmz.algorithm.graph;

import com.lmz.my.leetcode.TransformUtil;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge934 {
    /**
     * 两次BFS
     * 多源最短路径：标记一座到为所有点为2，然后2的所有点作为起点，找到最近的1
     */
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        //右下左上（顺时针）移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> queueTwo = new LinkedList<>();
        //添加1座岛屿的点，并标记访问为2
        boolean mark = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    grid[i][j] = 2;
                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        int x = point[0], y = point[1];
                        queueTwo.add(new int[]{x, y, -1});
                        for (var item : next) {
                            int nextX = x + item[0];
                            int nextY = y + item[1];
                            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1) {
                                grid[nextX][nextY] = 2;
                                queue.add(new int[]{nextX, nextY});
                            }
                        }
                    }
                    mark = true;
                    break;
                }
            }
            if(mark){
                break;
            }
        }
        while (!queueTwo.isEmpty()) {
            int[] point = queueTwo.poll();
            int x = point[0], y = point[1];
            for (var item : next) {
                int nextX = x + item[0];
                int nextY = y + item[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] != 2) {
                    if(grid[nextX][nextY] == 1){
                        return point[2]+1;
                    }
                    grid[nextX][nextY] = 2; //标记访问
                    queueTwo.add(new int[]{nextX, nextY, point[2]+1});
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        ShortestBridge934 shortestBridge934 = new ShortestBridge934();

        System.out.println(shortestBridge934.shortestBridge(TransformUtil.toIntMatrix(
                "[[0,1,0],[0,0,0],[0,0,1]]")));
        System.out.println(shortestBridge934.shortestBridge(TransformUtil.toIntMatrix(
                "[[0,1,0],[0,0,0],[0,0,1]]")) == 2);

        System.out.println(shortestBridge934.shortestBridge(TransformUtil.toIntMatrix(
                "[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]")));
        System.out.println(shortestBridge934.shortestBridge(TransformUtil.toIntMatrix(
                "[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]")) == 1);

        //Matrix.printMatrix(TransformString.toIntMatrix(
        //        "[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]"));
    }
}

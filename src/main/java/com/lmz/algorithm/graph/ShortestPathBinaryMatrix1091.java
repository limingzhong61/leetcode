package com.lmz.algorithm.graph;

import com.lmz.my.leetcode.TransformUtil;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0){
            return -1;
        }
        return bfs(0, 0, grid);
    }


    public int bfs(int x, int y, int[][] grid) {
        int res = 0;
        //上方向开始（顺时针）的8个方向移动数组
        int[][] next = new int[][]{
                {0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 1});
        int m = grid.length, n = grid[0].length;
        grid[x][y] = 2; //标记访问
        boolean success = false;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            x = point[0];
            y = point[1];
            int length = point[2];
            res = Math.max(length, res);
            if (x == m - 1 && y == n - 1) {
                success = true;
                break;
            }

            for (int k = 0; k < 8; k++) {
                int nextX = point[0] + next[k][0];
                int nextY = point[1] + next[k][1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && grid[nextX][nextY] == 0) {
                    grid[nextX][nextY] = 2; //标记访问
                    queue.add(new int[]{nextX, nextY, length + 1});
                }
            }
        }
        return success ? res : -1;
    }

    public static void main(String[] args) {
        ShortestPathBinaryMatrix1091 shortestPathBinaryMatrix = new ShortestPathBinaryMatrix1091();
        System.out.println(shortestPathBinaryMatrix.shortestPathBinaryMatrix(TransformUtil.toIntMatrix(
                "[[0,0,1,0],[1,0,1,0],[1,1,0,1],[0,0,0,0]]")));
        System.out.println(shortestPathBinaryMatrix.shortestPathBinaryMatrix(TransformUtil.toIntMatrix(
                "[[0,0,1,0],[1,0,1,0],[1,1,0,1],[0,0,0,0]]")) == 4);

        System.out.println(shortestPathBinaryMatrix.shortestPathBinaryMatrix(TransformUtil.toIntMatrix(
                "\n" +
                        "[[0,1],[1,0]]")));
        System.out.println(shortestPathBinaryMatrix.shortestPathBinaryMatrix(TransformUtil.toIntMatrix(
                "\n" +
                        "[[0,1],[1,0]]")) == 2);
        //Matrix.printMatrix(TransformString.toIntMatrix(
        //        "[[0,0,1,0],[1,0,1,0],[1,1,0,1],[0,0,0,0]]"));
    }
}

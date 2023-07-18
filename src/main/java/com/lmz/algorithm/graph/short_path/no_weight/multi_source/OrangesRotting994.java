package com.lmz.algorithm.graph.short_path.no_weight.multi_source;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting994 {
    /**
     * 多源最短路径-BFS
     *
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        //右下左上（顺时针）移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        //<x,y,dist>
        Queue<int[]> queue = new LinkedList<>();
        int cntNew = 0;
        //添加所有的2
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j,0});
                    visited[i][j] = true;
                }else if(grid[i][j] == 1){
                    cntNew++;
                }
            }
        }
        int maxDist = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            maxDist = Math.max(maxDist,point[2]);
            for (var item : next) {
                int nextX = x + item[0];
                int nextY = y + item[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1 && !visited[nextX][nextY]  ) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, point[2] + 1});
                    cntNew--;
                }
            }
        }
        if(cntNew > 0){ //无论如何都不能腐烂全部的新鲜橘子
            return -1;
        }
        return maxDist;
    }

    
    
}

package com.lmz.algorithm.graph;

public class NumEnclaves1020 {
    /**
     * 如果为1的飞地没有点在边界上，则可统计为孤立飞地
     */
    int tempCnt = 0;
    public int numEnclaves(int[][] grid) {
        //1 <= grid.length, grid[0].length <= 100
        int m = grid.length, n = grid[0].length;
        int cnt = 0;
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (grid[i][j] == 1) {
                    tempCnt = 0;
                    if(dfs(i, j, grid)){
                        cnt += tempCnt;
                    }
                }
            }
        }
        return cnt;
    }



    private boolean dfs(int x, int y, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        tempCnt++;
        grid[x][y] = 2; //标记访问
        //右下左上（顺时针）移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        boolean res = true;
        for (int k = 0; k < 4; k++) {
            int nextX = x + next[k][0];
            int nextY = y + next[k][1];

            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                    && grid[nextX][nextY] == 1) {
                if(nextX == m-1 || nextX == 0 ||
                        nextY == n-1 || nextY == 0 || !dfs(nextX, nextY, grid)){
                    res = false; //不能在这直接return，因为需要全部标记
                }
            }
        }
        return res;
    }

}

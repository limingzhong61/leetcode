package codeofli.leetcode.other.everyday;

import codeofli.my.leetcode.TransformUtil;

import java.util.Arrays;

public class CherryPickup741 {
    /**
     * leetcode：记忆化搜索
     * 一个人来回走等价成两个人从起点走到终点
     * `dp[x1][y1][x2][y2]` 表示第一个人在位置 `(x1, y1)` 处，
     * 第二个人在位置 `(x2, y2)` 处，走到终点能摘取到的最大樱桃数量。
     */
    public int cherryPickup(int[][] grid) {
        this.n = grid.length;
        int[][][][] dp = new int[n][n][n][n];
        for (var a : dp) {
            for (var b : a) {
                for (var c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }
        dp[n - 1][n - 1][n - 1][n - 1] = grid[n-1][n-1];
        //for(int i)
        return Math.max(f(grid, dp, 0, 0, 0, 0),0); //0无解情况
    }
    /**
     * leetcode：记忆化搜索
     * 一个人来回走等价成两个人从起点走到终点
     * `dp[x1][y1][x2][y2]` 表示第一个人在位置 `(x1, y1)` 处，
     * 第二个人在位置 `(x2, y2)` 处，走到终点能摘取到的最大樱桃数量。
     */
    int n = 0;

    public int cherryPickup2(int[][] grid) {
        this.n = grid.length;
        int[][][][] dp = new int[n][n][n][n];
        for (var a : dp) {
            for (var b : a) {
                for (var c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }
        dp[n - 1][n - 1][n - 1][n - 1] = grid[n-1][n-1];
        return Math.max(f(grid, dp, 0, 0, 0, 0),0); //0无解情况
    }

    private int f(int[][] grid, int[][][][] dp, int x1, int y1, int x2, int y2) {
        //if (x1 == n - 1 && y1 == n - 1) { //A、B同时到达终点 && x2 == n - 1 && y2 == n - 1
        //    return grid[n - 1][n - 1];
        //}
        if (dp[x1][y1][x2][y2] != -1) {
            return dp[x1][y1][x2][y2];
        }
        //只能右下移动数组
        int[][] next = new int[][]{
                {1, 0}, {0, 1}
        };
        int cnt = 0,res = Integer.MIN_VALUE;
        if (x1 == x2 && y1 == y2) { // A,B在同一位置
            cnt +=  grid[x1][y1];
        } else {
            cnt +=  grid[x1][y1] + grid[x2][y2];
        }
        for (int[] item : next) {
            int nextX1 = x1 + item[0];
            int nextY1 = y1 + item[1];
            if (nextX1 >= 0 && nextX1 < n && nextY1 >= 0 && nextY1 < n
                    && grid[nextX1][nextY1] != -1) {
                for (int[] item2 : next) {
                    int nextX2 = x2 + item2[0];
                    int nextY2 = y2 + item2[1];
                    if (nextX2 >= 0 && nextX2 < n && nextY2 >= 0 && nextY2 < n
                            && grid[nextX2][nextY2] != -1) {
                        res = Math.max(res, cnt + f(grid, dp, nextX1, nextY1, nextX2, nextY2));
                    }

                }
            }
        }
        return dp[x1][y1][x2][y2] = res;
    }
    /**
     * leetcode：dp
     * f[k][x1][x2]表示A,B两人走了k步，并分别在(x1,k-x1)(x2,k-x2)
     */
    //public int cherryPickup(int[][] grid) {
    //    int n = grid.length;
    //    //只能右下移动数组
    //    int[][] next = new int[][]{
    //            {1, 0}, {0, 1}
    //    };
    //    int[][][] f = new int[2 * n - 2][n][n];
    //    for (int k = 0; k <= 2 * n - 2; k++) {
    //        for(int x)
    //    }
    //    for (int i = 0; i < n; i++) {
    //        for (int j = 0; j < n; j++) {
    //            if (i == 0) { //不能从上面过来
    //                if (j == 0) { //0,0
    //                    f[k][i][j] = grid[i][j] == 0 ? 1 : 0;
    //                } else { //能从右边过来
    //                    f[]
    //                }
    //
    //            }
    //        }
    //    }
    //
    //}

    /**
     * 两遍dfs：超时
     */
    public int cherryPickup1(int[][] grid) {
        int n = grid.length;
        this.visited = new boolean[n][n];
        if (n == 1) {
            return grid[0][0] == 1 ? 1 : 0;
        }
        this.maxCnt = 0;
        dfsToBottom(grid, 0, 0, 0);
        return maxCnt;
    }

    boolean[][] visited;
    int maxCnt = 0;

    private void dfsToBottom(int[][] grid, int x, int y, int cnt) {
        int n = grid.length;
        if (x == n - 1 && y == n - 1) {
            //返回时，访问清零
            for (var item : visited) {
                Arrays.fill(item, false);
            }
            dfsToTop(grid, n - 1, n - 1, cnt);
        }
        visited[x][y] = true; //标记访问
        //只能右下移动数组
        int[][] next = new int[][]{
                {1, 0}, {0, 1}
        };
        for (int[] item : next) {
            int nextX = x + item[0];
            int nextY = y + item[1];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n
                    && grid[nextX][nextY] != -1 && !visited[nextX][nextY]) {
                if (grid[nextX][nextY] == 1) {
                    grid[nextX][nextY] = 0;
                    dfsToBottom(grid, nextX, nextY, cnt + 1);
                    grid[nextX][nextY] = 1;
                } else {
                    dfsToBottom(grid, nextX, nextY, cnt);
                }
            }
        }
        visited[x][y] = false; //回溯，还原
    }

    private void dfsToTop(int[][] grid, int x, int y, int cnt) {
        int n = grid.length;
        if (x == 0 && y == 0) {
            maxCnt = Math.max(maxCnt, cnt);
        }
        visited[x][y] = true; //标记访问
        //只能左上移动数组
        int[][] next = new int[][]{
                {-1, 0}, {0, -1}
        };
        for (int[] item : next) {
            int nextX = x + item[0];
            int nextY = y + item[1];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n
                    && grid[nextX][nextY] != -1 && !visited[nextX][nextY]) {
                if (grid[nextX][nextY] == 1) {
                    grid[nextX][nextY] = 0;
                    dfsToTop(grid, nextX, nextY, cnt + 1);
                    grid[nextX][nextY] = 1;
                } else {
                    dfsToTop(grid, nextX, nextY, cnt);
                }
            }
        }
        visited[x][y] = false; //回溯，还原
    }

    public static void main(String[] args) {
        CherryPickup741 cherryPickup741 = new CherryPickup741();
        //testCase(cherryPickup741, "[[0, 1, -1],\n" +
        //        " [1, 0, -1],\n" +
        //        " [1, 1,  1]]", 5);
        //testCase(cherryPickup741, "[[1]]", 1);
        //testCase(cherryPickup741, "[[1,0],[0,1]]", 2);
        //testCase(cherryPickup741, "[[1,1,-1],[1,-1,1],[-1,1,1]]", 0);
        testCase(cherryPickup741, "[[0,0,1,0,0,1,0,1,1,-1,0,0,-1,-1,0,1,1,-1,0,-1],[1,1,1,0,1,0,0,0,0,1,1,1,1,1,1,1,0,0,1,0],[1,0,1,1,0,0,1,0,0,0,1,0,1,1,1,-1,0,1,1,0]," +
                "[0,1,1,0,0,0,1,0,1,1,0,-1,1,0,0,1,0,0,1,1],[-1,0,-1,1,0,0,1,1,0,0,1,1,0,-1,1,0,0,0,1,1],[0,0,1,0,1,1,0,0,1,0,0,1,0,1,1,1,1,1,1,0]," +
                "[0,0,0,1,0,1,1,0,0,1,1,-1,1,0,1,1,0,1,1,0],[0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,1,0,1,1],[0,0,0,-1,1,0,0,1,0,0,1,1,1,1,0,0,0,1,1,0]," +
                "[1,0,1,1,1,0,0,1,1,0,1,0,0,0,-1,0,-1,0,1,0],[0,1,-1,1,1,1,1,0,1,0,0,1,1,0,-1,1,0,0,-1,0],[0,0,0,0,1,0,1,0,0,-1,0,1,0,-1,0,0,1,0,1,1]," +
                "[1,-1,-1,0,0,1,1,1,0,1,1,1,1,1,1,0,0,0,1,0],[-1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,0,1,0,1,0],[0,1,-1,1,1,1,0,0,1,-1,1,1,0,1,0,1,0,-1,1,0]," +
                "[1,-1,1,0,1,1,1,0,0,0,1,1,1,1,-1,0,0,1,0,-1],[-1,1,0,0,0,1,1,1,1,1,0,1,1,-1,0,1,0,0,1,0]," +
                "[0,0,0,-1,0,1,0,0,0,0,0,0,1,0,1,1,0,0,0,1],[0,1,0,0,0,0,0,0,0,1,1,1,1,0,0,1,0,0,0,1],[0,0,0,1,-1,0,-1,1,0,1,0,0,0,0,1,0,0,1,-1,0]]", 52);
    }

    private static void testCase(CherryPickup741 cherryPickup741, String s, int i) {

        System.out.println(cherryPickup741.cherryPickup(TransformUtil.toIntMatrix(s)));
        System.out.println(cherryPickup741.cherryPickup(TransformUtil.toIntMatrix(s)) == i);
    }
}

package codeofli.leetcode.dp.intro.dag;

import codeofli.my.leetcode.TransformUtil;

public class MinPathSum64 {
    /**
     * leetcode: 最左最上，边界初始化优化
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }

    /**
     * f[i][j] 表示在i,j位置最小总和数字
     */
    public int minPathSum1(int[][] grid) {
        //1 <= m, n <= 200
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n]; //多扩展一维便于边界处理
        f[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= 1) {
                    f[i][j] = f[i - 1][j] + grid[i][j];
                }
                if (j >= 1) {
                    if (f[i][j] == 0) {
                        f[i][j] = f[i][j - 1] + grid[i][j];
                    } else {
                        f[i][j] = Math.min(f[i][j], f[i][j - 1] + grid[i][j]);
                    }
                }
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinPathSum64 minPathSum64 = new MinPathSum64();
        System.out.println(minPathSum64.minPathSum(TransformUtil.toIntMatrix(" [[1,3,1],[1,5,1],[4,2,1]]")));
        System.out.println(minPathSum64.minPathSum(TransformUtil.toIntMatrix(" [[1,3,1],[1,5,1],[4,2,1]]")) == 7);
        System.out.println(minPathSum64.minPathSum(TransformUtil.toIntMatrix(" [[1,2,3],[4,5,6]]")));
        System.out.println(minPathSum64.minPathSum(TransformUtil.toIntMatrix("[[1,2,3],[4,5,6]]")) == 12);
    }
}

package lmz.algorithm.other.dp;

public class MaxValue47 {

    /**
     * dp:每次向右或者向下移动一格
     * //多开一行一列的空间能够让代码更简洁
     * dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
     * dp[i][j] = max(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j])
     */
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + grid[i-1][j-1], dp[i][j - 1] + grid[i-1][j-1]);
            }
        }
        return dp[row][col];
    }

    /**
     * dp:每次向右或者向下移动一格
     * dp[i][j] = max(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j])
     */
    public int maxValue1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int leftValue = 0;
                if (i != 0) {
                    leftValue = dp[i - 1][j];
                }
                int upValue = 0;
                if (j != 0) {
                    upValue = dp[i][j - 1];
                }
                dp[i][j] = Math.max(leftValue + grid[i][j], upValue + grid[i][j]);
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        MaxValue47 maxValue47 = new MaxValue47();
        System.out.println(maxValue47.maxValue(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
        System.out.println(maxValue47.maxValue(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }) == 12);
    }
}

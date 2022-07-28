package codeofli.leetcode.dp.intro.graph;

import codeofli.my.leetcode.StringTransformUtil;

public class MaximalSquare221 {
    /**
     * 用 $dp(i, j)$ 表示以 (i, j)为右下角，且只包含 1 的正方形的边长最大值
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                maxSide = 1;
            }
        }
        for (int j = 1; j < columns; j++) {
            if(matrix[0][j] == '1'){
                dp[0][j]  = 1;
                maxSide = 1;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

    /**
     * f[i,j,k]表示以i为右下角，长度为k的正方形是否全为1
     */
    public int maximalSquare1(char[][] matrix) {
        //1 <= m, n <= 300
        int m = matrix.length, n = matrix[0].length;
        int min = Math.min(m, n);
        boolean[][][] f = new boolean[m][n][min + 1];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][1] = matrix[i][j] == '1';
                if (f[i][j][1]) {
                    res = Math.max(res, 1);
                }
            }
        }

        for (int k = 2; k <= min; k++) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    f[i][j][k] = matrix[i][j] == '1' && f[i + 1][j + 1][k - 1]
                            && f[i + 1][j][k - 1] && f[i][j + 1][k - 1];
                    if (f[i][j][k]) {
                        res = Math.max(res, k * k);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximalSquare221 maximalSquare221 = new MaximalSquare221();
        testCase(maximalSquare221, "[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"]," +
                "[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]\n", 4);

        testCase(maximalSquare221, "[[\"0\",\"0\",\"0\",\"0\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"1\"]," +
                "[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"]]\n", 9);
        testCase(maximalSquare221, "[[\"0\",\"1\"],[\"1\",\"0\"]]", 1);
        testCase(maximalSquare221, "[[\"1\",\"1\"],[\"1\",\"1\"]]", 4);
        testCase(maximalSquare221, "[[\"0\"]]", 0);
        testCase(maximalSquare221, "[[\"0\",\"1\"]]", 1);
    }

    private static void testCase(MaximalSquare221 maximalSquare221, String original, int x) {
        System.out.println(maximalSquare221.maximalSquare(StringTransformUtil.toCharMatrix(
                original)));
        System.out.println(maximalSquare221.maximalSquare(StringTransformUtil.toCharMatrix(
                original)) == x);
    }
}

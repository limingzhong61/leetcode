package lmz.algorithm.other.medium.old;

import lmz.my.leetcode.TransformUtil;

public class Largest1BorderedSquare1139 {
    /**
     * 前缀和
     */
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 行idx，前缀和   列idx，前缀和
        int[][] rowSum = new int[m][n + 1], colSum = new int[n][m + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                rowSum[i][j] = rowSum[i][j - 1] + grid[i][j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                colSum[i][j] = colSum[i][j - 1] + grid[j - 1][i];
            }
        }
        int max = Math.min(m, n);
        for (int len = max; len > 0; len--) {
            for (int i = 0; i <= m - len; i++) { // 左上角枚举
                for (int j = 0; j <= n - len; j++) {
                    // 上 下 左 右
                    if (rowSum[i][j + len] - rowSum[i][j] == len &&
                            rowSum[i + len - 1][j + len] - rowSum[i + len - 1][j] == len &&
                            colSum[j][i + len] - colSum[j][i] == len &&
                            colSum[j + len - 1][i + len] - colSum[j + len - 1][i] == len
                    ) {
                        return len * len;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 前缀和
     */
    public int largest1BorderedSquare1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        var rowPrefixSum = new int[m][n + 1];
        var colPrefixSum = new int[m + 1][n];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                rowPrefixSum[i][j] = rowPrefixSum[i][j - 1] + grid[i][j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                colPrefixSum[j][i] = colPrefixSum[j - 1][i] + grid[j - 1][i];
            }
        }
        int max = Math.min(m, n);
        for (int len = max; len > 0; len--) {
            for (int i = 0; i <= m - len; i++) { // 左上角枚举
                for (int j = 0; j <= n - len; j++) {
                    // 上 下 左 右
                    if (rowPrefixSum[i][j + len] - rowPrefixSum[i][j] == len &&
                            rowPrefixSum[i + len - 1][j + len] - rowPrefixSum[i + len - 1][j] == len &&
                            colPrefixSum[i + len][j] - colPrefixSum[i][j] == len &&
                            colPrefixSum[i + len][j + len - 1] - colPrefixSum[i][j + len - 1] == len
                    ) {
                        return len * len;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Largest1BorderedSquare1139 largest1BorderedSquare1139 = new Largest1BorderedSquare1139();
        testCase(largest1BorderedSquare1139, "[[1,1,1],[1,0,1],[1,1,1]]", 9);
        testCase(largest1BorderedSquare1139, "[[0]]", 0);

    }

    private static void testCase(Largest1BorderedSquare1139 largest1BorderedSquare1139, String original, int x) {
        System.out.println(largest1BorderedSquare1139.largest1BorderedSquare(TransformUtil.toIntMatrix(original)));
        System.out.println(largest1BorderedSquare1139.largest1BorderedSquare(TransformUtil.toIntMatrix(original)) == x);
    }
}

package lmz.leetcode.prefix_sum;

/**
 * 二维数组前缀和
 * sum[i][j]表示matrix[0,0]->[i-1][j-1]的元素和
 */
class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = matrix[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
    }

    /**
     *
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return  返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2+1] + sum[row1][col2];
    }
}

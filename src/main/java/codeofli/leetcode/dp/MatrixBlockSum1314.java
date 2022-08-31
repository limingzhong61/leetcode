package codeofli.leetcode.dp;

import codeofli.my.leetcode.TransformUtil;
import codeofli.my.util.matrix.MatrixUtil;

public class MatrixBlockSum1314 {
    /**
     * 使用二维前缀和
     * f[i][j]表示（i-1,j-1)的元素和
     * 求 answer[i][j] 的值，其实就是把 mat 数组中，以（i，j） 为原点，
     * 周围横纵形成一个边长为 2k 的正方形，框起来的所有 mat[i][j] （要合法）的和
     */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = f[i][j - 1] + f[i - 1][j] - f[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = Math.max(0, i - k), x2 = Math.min(m - 1, i + k);
                int y1 = Math.max(0, j - k), y2 = Math.min(n - 1, j + k);
                ans[i][j] = f[x2 + 1][y2 + 1] - f[x1][y2 + 1] - f[x2 + 1][y1] + f[x1][y1];
            }
        }
        return ans;
    }
    /**
     * 求 answer[i][j] 的值，其实就是把 mat 数组中，以（i，j） 为原点，
     * 周围横纵形成一个边长为 2k 的正方形，框起来的所有 mat[i][j] （要合法）的和
     * 因为m,n不大，故暴力计算即可。
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n, k <= 100
     * 1 <= mat[i][j] <= 100
     */
    public int[][] matrixBlockSum1(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = Math.max(0, i - k);
                int bottom = Math.min(m - 1, i + k);
                int left = Math.max(0, j - k);
                int right = Math.min(n - 1, j + k);
                ans[i][j] = getSum(mat, top, bottom, left, right);
            }
        }
        return ans;
    }

    private int getSum(int[][] mat, int top, int bottom, int left, int right) {
        int sum = 0;
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                sum += mat[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MatrixBlockSum1314 matrixBlockSum1314 = new MatrixBlockSum1314();
        MatrixUtil.printMatrix(matrixBlockSum1314.matrixBlockSum(TransformUtil.toIntMatrix("[[1,2,3],[4,5,6],[7,8,9],[10,11,12],[13,14,15]]"),
                1));
    }
}

package codeofli.leetcode.other.easy;

public class NumSpecial1582 {
    /**
     * 先统计再求和。
     */
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rowsSum = new int[m];
        int[] colsSum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowsSum[i] += mat[i][j];
                colsSum[j] += mat[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowsSum[i] == 1 && colsSum[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 数据范围小，直接暴力
     * 1 <= rows, cols <= 100
     */
    public int numSpecial1(int[][] mat) {
        int cnt = 0;
        int rows = mat.length, cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(mat[i][j] == 1){
                    boolean flag = true;
                    for (int k = 0; k < rows; k++) {
                        if (k != i && mat[k][j] == 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int y = 0; y < cols; y++) {
                            if (y != j && mat[i][y] == 1) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}

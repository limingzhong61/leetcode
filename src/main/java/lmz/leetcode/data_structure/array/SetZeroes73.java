package lmz.leetcode.data_structure.array;

public class SetZeroes73 {
    /**
     * 请使用 原地 算法。
     * 可以用第一行、或者第一列来标记申明是否改行、列为0；
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //先统计第一列、行是否有零
        boolean oneCol = false, oneRow = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                oneRow = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                oneCol = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //最后才修改第一列和最后一列
        if (oneRow) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (oneCol) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}

package com.lmz.my.util.matrix;

public class MatrixUtil {
    /**
     * @param a n*n
     */
    public static void Transposition(int[][] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
    }

    public static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + ",");
            }
            System.out.println();
        }
        //空行的打印，便于观察
        System.out.println();
    }

    public static void printMatrix(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + ",");
            }
            System.out.println();
        }
        //空行的打印，便于观察
        System.out.println();
    }

    public static void printMatrix(int[][] a,int row,int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void setZero(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = 0;
            }
        }
    }

    public static void setFalse(boolean[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = false;
            }
        }
    }

    /**
     * 一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
     *如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int matRow = mat.length,matCol = mat[0].length;
        if(matRow * matCol != r *c){
            return mat;
        }
        int[][] newMatrix = new int[r][c];
        int cnt = 0;
        for (int i = 0; i < matRow; i++) {
            for (int j = 0; j < matCol; j++) {
                newMatrix[cnt / c][cnt % c] = mat[i][j];
                cnt++;
            }
        }
        return newMatrix;
    }
}

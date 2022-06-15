package codeofli.my.matrix;

public class Matrix {
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
}

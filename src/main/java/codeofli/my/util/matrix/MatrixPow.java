package codeofli.my.util.matrix;

public class MatrixPow {

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            //等价于n%2 == 1,位运算更快
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            //等价于 n /= 2;位运算更快
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] quickPow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n != 0) {
            if (n % 2 == 1) {
                ret = multiply(a, ret);
            }
            a = multiply(a, a);
            n /= 2;
        }
        return ret;
    }


    /**
     * a,b均为n*n
     */
    private int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}

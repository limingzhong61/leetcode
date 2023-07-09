package com.lmz.algorithm.other.old.intro;

public class ClimbStairs70 {
    /**
     * leetcode :矩阵快速幂优化
     */
    public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        //矩阵计算 M^n[0][0] = f(n)
        return res[0][0];

    }

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


    /**
     * leetcode :滚动数组优化
     * 状态：steps[i]：到达i能走的此数
     * 初始边界：steps[1] = 1， steps[2]=2;
     * 传递方程：steps[i] = steps[i-1] + steps[i-2];
     */
    public int climbStairs2(int n) {
        // steps[i]：到达i的方案数
        int steps0 = 1; //
        int steps1 = 1;
        int steps2 = 1;
        for (int i = 2; i <= n; i++) {
            steps2 = steps1 + steps0;
            steps0 = steps1;
            steps1 = steps2;
            // System.out.println(steps2);
        }
        return steps2;
    }

    /**
     * 状态：steps[i]：到达i能走的此数
     * 初始边界：steps[1] = 1， steps[2]=2;
     * 传递方程：steps[i] = steps[i-1] + steps[i-2];
     */
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        // steps[i]：到达i能走的此数
        int[] steps = new int[n + 1];
        steps[1] = 1; //
        steps[2] = 2;
        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
            //System.out.println(steps[i]);
        }
        return steps[n];
    }


    public static void main(String[] args) {
        ClimbStairs70 climbStairs70 = new ClimbStairs70();
        System.out.println(climbStairs70.climbStairs(2));
    }
}

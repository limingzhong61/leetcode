package com.lmz.leetcode.practice.p.old.intro;

public class NumSquares279 {
    /**
     * leetcode：数学-四平方和定理
     */
    public int numSquares(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }

    /**
     * leetcode:dp
     */
    public int numSquares2(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

    /**
     * 枚举 O(n*n)
     */
    public int numSquares1(int n) {
        int[] f = new int[n + 1];
        //for (int i = 1; i * i <= n; i++) {
        //    f[i * i] = 1;
        //}
        for (int i = 1; i <= n; i++) {
            long round = Math.round(Math.sqrt(i));
            if (i == round*round) {
                f[i] = 1;
            }else{

                f[i] = Integer.MAX_VALUE;
                for (int j = 1; j <= i / 2; j++) {
                    f[i] = Math.min(f[i], f[j] + f[i - j]);
                }
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        NumSquares279 numSquares279 = new NumSquares279();
        testCase(numSquares279, 12, 3);
        testCase(numSquares279, 13, 2);
        testCase(numSquares279, 10000, 1);
        testCase(numSquares279, 9998, 3);
    }

    private static void testCase(NumSquares279 numSquares279, int n, int x) {
        System.out.println(numSquares279.numSquares(n));
        System.out.println(numSquares279.numSquares(n) == x);
    }
}

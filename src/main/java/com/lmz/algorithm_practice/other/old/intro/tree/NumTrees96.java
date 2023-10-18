package com.lmz.algorithm_practice.other.old.intro.tree;

public class NumTrees96 {
    /**
     * leetcode:卡特兰数
     */
    public int numTrees(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
    /**
     * leetcode:
     */
    public int numTrees2(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                g[i] += g[j-1] * g[i - j];
            }
        }
        return g[n];
    }
    /**
     * f(i,j)表示[i,j]能有多少种组成方法。
     */
    public int numTrees1(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                int j = i + k - 1;
                if (j > n) {
                    break;
                }
                for (int a = i; a <= j; a++) { // a为root
                    int left = 1, right = 1;
                    if (a - 1 >= i) {
                        left = f[i][a - 1];
                    }
                    if (a + 1 <= j) {
                        right = f[a + 1][j];
                    }
                    f[i][j] += left * right;
                }
            }
        }
        return f[1][n];
    }

    public static void main(String[] args) {
        NumTrees96 numTrees96 = new NumTrees96();
        testCase(numTrees96, 3, 5);
        testCase(numTrees96, 1, 1);
        testCase(numTrees96, 19, 1767263190);
    }

    private static void testCase(NumTrees96 numTrees96, int n, int n1) {
        System.out.println(numTrees96.numTrees(n));
        System.out.println(numTrees96.numTrees(n) == n1);
    }
}

package codeofli.leetcode.contest.c306;

public class LargestLocal {
    //3 <= n <= 100
    //1 <= grid[i][j] <= 100
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int max = Integer.MIN_VALUE;
                for (int a = i - 1; a <= i + 1; a++) {
                    for (int b = j - 1; b <= j + 1; b++) {
                        max = Math.max(grid[a][b], max);
                    }
                }
                res[i - 1][j - 1] = max;
            }
        }
        return res;
    }
}

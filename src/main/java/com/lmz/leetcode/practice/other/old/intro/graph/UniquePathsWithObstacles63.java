package com.lmz.leetcode.practice.other.old.intro.graph;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class UniquePathsWithObstacles63 {
    /**
     * dp: f[i][j]表示到达i,j的不同路径
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                f[i][0] = f[i - 1][0];
            }

        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                f[0][i] = f[0][i - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    f[i][j] += f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles63 uniquePathsWithObstacles63 = new UniquePathsWithObstacles63();
        testCase(uniquePathsWithObstacles63, "[[0,0,0],[0,1,0],[0,0,0]]", 2);
        testCase(uniquePathsWithObstacles63, "[[0,1],[0,0]]", 1);
        testCase(uniquePathsWithObstacles63, "[[1]]", 0);
        testCase(uniquePathsWithObstacles63, "[[0,0]]", 1);
    }

    private static void testCase(UniquePathsWithObstacles63 uniquePathsWithObstacles63, String original, int x) {
        System.out.println(uniquePathsWithObstacles63.uniquePathsWithObstacles(
                TransformUtil.toIntMatrix(original)));
        System.out.println(uniquePathsWithObstacles63.uniquePathsWithObstacles(
                TransformUtil.toIntMatrix(original)) == x);
    }
}

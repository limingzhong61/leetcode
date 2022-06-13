package codeofli.leetcode.content;

import codeofli.my.leetcode.TransformString;

import java.util.Arrays;

public class minPathCost {
    /**
     * 迪杰斯特拉
     * 矩阵大小为 m x n ，由从 0 到 m * n - 1 的不同整数组成
     */
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] minPath = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(minPath[i], Integer.MAX_VALUE);
        }
        //第一层到自己的距离
        for (int i = 0; i < n; i++) {
            minPath[0][i] = grid[0][i];
        }
        for (int i = 0; i < m - 1; i++) {

            for (int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++){
                    int gridVal = grid[i][k];
                    minPath[i+1][j] = Math.min(grid[i + 1][j] + moveCost[gridVal][j] + minPath[i][k], minPath[i+1][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(grid[n - 1][i], min);
        }
        return min;
    }

    public static void main(String[] args) {
        minPathCost minPathCost = new minPathCost();
        TransformString.toIntMatrix("[[5,3],[4,0],[2,1]]");
        System.out.println(minPathCost.minPathCost(TransformString.toIntMatrix("[[5,3],[4,0],[2,1]]")
                , TransformString.toIntMatrix("[[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]")));
    }
}

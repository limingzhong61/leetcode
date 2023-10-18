package com.lmz.algorithm_practice.graph;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class NumIslands200 {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(i, j, grid);
                }
            }
        }
        return cnt;
    }

    int[][] next = new int[][]{
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1' ) {
            return;
        }
        //'2'表示访问过
        grid[i][j] = '2';
        for (int k = 0; k < 4; k++) {
            dfs(i + next[k][0], j + next[k][1], grid);
        }
    }

    public static void main(String[] args) {
        NumIslands200 numIslands200 = new NumIslands200();
        System.out.println(numIslands200.numIslands(TransformUtil.toCharMatrix("[\n" +
                "  [\"1\",\"1\",\"1\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"0\",\"0\"]\n" +
                "]")));
        System.out.println(numIslands200.numIslands(TransformUtil.toCharMatrix("[\n" +
                "  [\"1\",\"1\",\"1\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"0\",\"0\"]\n" +
                "]")) == 1);

        System.out.println(numIslands200.numIslands(TransformUtil.toCharMatrix("[\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"1\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"1\",\"1\"]\n" +
                "]")));
        System.out.println(numIslands200.numIslands(TransformUtil.toCharMatrix("[\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"1\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"1\",\"1\"]\n" +
                "]")) == 3);
    }
}

package lmz.my.solution_template.graph_theory.traverse.move_matrix;

import lmz.my.leetcode.TransformUtil;

/**
 * 上下左右：移动矩阵的dfs遍历
 */
public class DFS {
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
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        //'2'表示访问过
        grid[i][j] = '2';
        for (int k = 0; k < 4; k++) {
            dfs(i + next[k][0], j + next[k][1], grid);
        }
    }

    public static void main(String[] args) {
        lmz.leetcode.graph_theory.NumIslands200 numIslands200 = new lmz.leetcode.graph_theory.NumIslands200();
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

package codeofli.my.solution_template.graph_theory;

import codeofli.my.leetcode.TransformUtil;

public class DFS {
    /**
     * 如果为0的岛屿没有点在边界上，则可统计为孤立岛屿
     */
    public int closedIsland(int[][] grid) {
        //1 <= grid.length, grid[0].length <= 100
        int m = grid.length, n = grid[0].length;
        int cnt = 0;
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (grid[i][j] == 0) {
                    cnt += dfs(i, j, grid) ? 1 : 0;
                }
            }
        }
        return cnt;
    }

    private boolean dfs(int x, int y, int[][] grid) {
        int m = grid.length, n = grid[0].length;

        grid[x][y] = 2; //标记访问
        //右下左上（顺时针）移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        boolean res = true;
        for (int[] item : next) {
            int nextX = x + item[0];
            int nextY = y + item[1];

            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                    && grid[nextX][nextY] == 0) {
                if(nextX == m-1 || nextX == 0 ||
                   nextY == n-1 || nextY == 0 || !dfs(nextX, nextY, grid)){
                    res = false; //不能在这直接return，因为需要全部标记
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DFS closedIsland1254 = new DFS();
        //
        testCase(closedIsland1254, "[[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]", 1);

        testCase(closedIsland1254, "[[1,1,1,1,1,1,1],\n" +
                "             [1,0,0,0,0,0,1],\n" +
                "             [1,0,1,1,1,0,1],\n" +
                "             [1,0,1,0,1,0,1],\n" +
                "             [1,0,1,1,1,0,1],\n" +
                "             [1,0,0,0,0,0,1],\n" +
                "             [1,1,1,1,1,1,1]]", 2);

        testCase(closedIsland1254, "[[0,1,1,1,0],[1,0,1,0,1]," +
                "[1,0,1,0,1],[1,0,0,0,1],[0,1,1,1,0]]", 1);

        testCase(closedIsland1254, "[[0,0,1,1,0,1,0,0,1,0],[1,1,0,1,1,0,1,1,1,0],[1,0,1,1,1,0,0,1,1,0]," +
                "[0,1,1,0,0,0,0,1,0,1],[0,0,0,0,0,0,1,1,1,0],[0,1,0,1,0,1,0,1,1,1]," +
                "[1,0,1,0,1,1,0,0,0,1],[1,1,1,1,1,1,0,0,0,0],[1,1,1,0,0,1,0,1,0,1],[1,1,1,0,1,1,0,1,1,0]]", 5);

        //Matrix.printMatrix(TransformString.toIntMatrix("[[0,0,1,1,0,1,0,0,1,0],[1,1,0,1,1,0,1,1,1,0],[1,0,1,1,1,0,0,1,1,0]," +
        //        "[0,1,1,0,0,0,0,1,0,1],[0,0,0,0,0,0,1,1,1,0],[0,1,0,1,0,1,0,1,1,1],[1,0,1,0,1,1,0,0,0,1],[1,1,1,1,1,1,0,0,0,0]," +
        //        "[1,1,1,0,0,1,0,1,0,1],[1,1,1,0,1,1,0,1,1,0]]"));

    }

    private static void testCase(DFS closedIsland1254, String s, int i) {
        System.out.println(closedIsland1254.closedIsland
                (TransformUtil.toIntMatrix(s)));
        System.out.println(closedIsland1254.closedIsland
                (TransformUtil.toIntMatrix(s)) == i);
    }


}

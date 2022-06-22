package codeofli.my.solution_template.graph_theory;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathWithBFS {
    /**
     * 多源最短路径-BFS
     */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        //右下左上（顺时针）移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        Queue<int[]> queue = new LinkedList<>();
        //添加所有的0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (var item : next) {
                int nextX = x + item[0];
                int nextY = y + item[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    mat[nextX][nextY] = mat[x][y] + 1;
                    queue.add(new int[]{nextX, nextY, mat[nextX][nextY]});
                }
            }
        }
        return mat;
    }
}

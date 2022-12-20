package lmz.leetcode.graph_theory;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExit1926 {
    /**
     * BFS 即可
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int x = entrance[0], y = entrance[1];
        //右下左上（顺时针）移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        maze[x][y] = '-'; //标记访问
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            x = point[0];
            y = point[1];
            for (int[] item : next) {
                int nextX = x + item[0];
                int nextY = y + item[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && maze[nextX][nextY] == '.') {
                    if (nextX == 0 || nextX == m - 1 || nextY == 0 || nextY == n - 1) {
                        return point[2] + 1;
                    }
                    maze[nextX][nextY] = '-'; //标记访问
                    queue.add(new int[]{nextX, nextY, point[2] + 1});
                }
            }
        }
        return -1;
    }


}

package codeofli.my.solution_template.graph_theory.grid_map;

import java.util.LinkedList;
import java.util.Queue;

public class GridMap {
    int[][] grid;
    //右下左上（顺时针）移动数组
    final int[][] nexts = new int[][]{
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };

    public GridMap(int[][] grid) {
        this.grid = grid;
    }

    /**
     * 使用bfs获取在x,y位置点的标记为flag格子图的大小
     *
     * @param x
     * @param y
     * @param flag
     * @return
     */
    public int getGridSize(int x, int y, int flag) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            sum++;
            for (int[] next : nexts) {
                int nextX = pos[0] + next[0];
                int nextY = pos[1] + next[1];
                if (checkRange(0,rows, nextX) && checkRange(0,cols, nextY)
                        && grid[nextX][nextY] == flag) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return sum;
    }

    /**
     * 使用bfs获取在x,y位置点的标记为flag格子图的面积大小，并将格子图值标记为mark
     *
     * @param x
     * @param y
     * @param flag
     * @param mark
     * @return
     */
    public int getAreaAndMark(int x, int y, int flag, int mark) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        grid[x][y] = mark;
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            sum++;
            for (int[] next : nexts) {
                int nextX = pos[0] + next[0];
                int nextY = pos[1] + next[1];
                if (checkRange(0,rows, nextX) && checkRange(0,cols, nextY)
                        && grid[nextX][nextY] == flag) {
                    grid[nextX][nextY] = mark;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return sum;
    }

    /**
     * 校验x是否是在 [start,end)中
     *
     * @param start
     * @param end
     * @param x
     * @return
     */
    public boolean checkRange(int start,int end, int x) {
        return x >= start && x < end;
    }

}

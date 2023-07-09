package com.lmz.algorithm.graph.grid_map;

import java.util.*;

public class LargestIsland827 {

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        int rows = grid.length;
        int cols = grid[0].length;
        int mark = 2;
        Map<Integer, Integer> map = new HashMap<>();
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int gridSize = getAreaAndMark(i, j, 1, mark);
                    map.put(mark, gridSize);
                    //有可能之前已经存在的面积是最大的，（即全部格子都是1）
                    maxArea = Math.max(maxArea,gridSize);
                    mark++;
                }
            }
        }
        //改变格子并统计
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Set<Integer> set = new HashSet<>();
                if (grid[i][j] == 0) {
                    int sum = 1;
                    for(int[] next : nexts){
                        int nextX = i + next[0];
                        int nextY = j + next[1];
                        if(valid(rows,nextX) && valid(cols,nextY)){
                            mark = grid[nextX][nextY];
                            if(!set.contains(mark)){
                                set.add(mark);
                                sum += map.getOrDefault(mark,0);
                            }
                        }
                    }
                    maxArea = Math.max(maxArea,sum);
                }
            }
        }
        return maxArea;
    }

    int[][] grid;
    boolean[][] visited;
    //右下左上（顺时针）移动数组
    final int[][] nexts = new int[][]{
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };

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
                if (valid(rows, nextX) && valid(cols, nextY)
                        && grid[nextX][nextY] == flag) {
                    grid[nextX][nextY] = mark;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return sum;
    }

    /**
     * 校验x是否是在 [0,n)中
     *
     * @param n
     * @param i
     * @return
     */
    public boolean valid(int n, int i) {
        return i >= 0 && i < n;
    }

    class GridMap {
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
                    if (valid(rows, nextX) && valid(cols, nextY)
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
                    if (valid(rows, nextX) && valid(cols, nextY)
                            && grid[nextX][nextY] == flag) {
                        grid[nextX][nextY] = mark;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
            return sum;
        }

        /**
         * 校验x是否是在 [0,n)中
         *
         * @param n
         * @param x
         * @return
         */
        public boolean valid(int n, int x) {
            return x >= 0 && x < n;
        }

    }
}

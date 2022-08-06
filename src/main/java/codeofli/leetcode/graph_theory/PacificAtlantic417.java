package codeofli.leetcode.graph_theory;

import codeofli.my.leetcode.TransformUtil;

import java.util.*;

public class PacificAtlantic417 {
    /**
     * leetcode: 太平洋为起点，统计能到太平洋的点。
     * 大西洋同理。最后计算能同时到达的点
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        //太平洋为起点，统计能到太平洋的点。
        for (int i = 0; i < m; i++) {
            bfs(i, 0, heights, pacific);
        }
        //重叠了左下角
        for (int j = 1; j < n; j++) {
            bfs(0, j, heights, pacific);
        }
        //大西洋为起点，统计能到大西洋的点。
        for (int i = 0; i < m; i++) {
            bfs(i, n - 1, heights, atlantic);
        }
        //重叠了右下角
        for (int j = 0; j < n - 1; j++) {
            bfs(m - 1, j, heights, atlantic);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public void bfs(int x, int y, int[][] heights, boolean[][] ocean) {
        if(ocean[x][y]){
            return;
        }
        //右下左上（顺时针）移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int m = heights.length, n = heights[0].length;
        ocean[x][y] = true; //标记访问

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            x = point[0];
            y = point[1];
            for (int k = 0; k < 4; k++) {
                int nextX = x + next[k][0];
                int nextY = y + next[k][1];
                int height = heights[x][y];
                // 逆流而上
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && !ocean[nextX][nextY] && height <= heights[nextX][nextY]) {
                    ocean[nextX][nextY] = true; //标记访问
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    /**
     * 多次BFS
     */
    public List<List<Integer>> pacificAtlantic1(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean[][] canTo = new boolean[m][n];
        //boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (var item : visited) {
                    Arrays.fill(item, false);
                }
                pacific = false;
                atlantic = false;
                if (bfs1(i, j, heights, visited, canTo)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    boolean pacific = false;
    boolean atlantic = false;

    public boolean bfs1(int i, int j, int[][] heights, boolean[][] visited, boolean[][] canTo) {
        //右下左上（顺时针）移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int m = heights.length, n = heights[0].length;
        visited[i][j] = true; //标记访问

        checkPacificAtlantic(i, j, heights);
        if (pacific && atlantic) {
            canTo[i][j] = true;
            return true;
        }
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int k = 0; k < 4; k++) {
                int nextX = x + next[k][0];
                int nextY = y + next[k][1];
                int height = heights[x][y];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && !visited[nextX][nextY] && height >= heights[nextX][nextY]) {
                    checkPacificAtlantic(nextX, nextY, heights);
                    if (pacific && atlantic || canTo[nextX][nextY]) {
                        canTo[i][j] = true;
                        return true;
                    }
                    visited[nextX][nextY] = true; //标记访问
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return false;
    }

    /**
     * 注意一个点：有可能就在夹角
     */
    public void checkPacificAtlantic(int x, int y, int[][] heights) {
        int m = heights.length, n = heights[0].length;
        if (x == 0 || y == 0) {
            pacific = true;
        }
        if (x == m - 1 || y == n - 1) {
            atlantic = true;
        }
    }

    public static void main(String[] args) {
        PacificAtlantic417 pacificAtlantic417 = new PacificAtlantic417();
        System.out.println(pacificAtlantic417.pacificAtlantic(TransformUtil.toIntMatrix("[[2,1],[1,2]]")));
    }
}

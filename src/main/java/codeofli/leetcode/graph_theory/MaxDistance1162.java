package codeofli.leetcode.graph_theory;

import codeofli.my.leetcode.StringTransformUtil;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxDistance1162 {
    /**
     * 多起点初始化-BFS
     */
    public int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        // 先把所有的陆地都入队。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            // 取出队列的元素，将其四周的海洋入队。
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1; // 这里我直接修改了原数组，因此就不需要额外的数组来标志是否访问
                hasOcean = true;
                queue.offer(new int[] {newX, newY});
            }
        }

        // 没有陆地或者没有海洋，返回-1。
        if (point == null || !hasOcean) {
            return -1;
        }

        // 返回最后一次遍历到的海洋的距离。
        return grid[point[0]][point[1]] - 1;

    }

    /**
     * BFS
     */
    public int maxDistance1(int[][] grid) {
        int maxDistance = 0;
        int m = grid.length,n = grid[0].length;
        int[][] distance = new int[m][n];
        for(var item : distance){
            Arrays.fill(item,Integer.MAX_VALUE);
        }
        int markNum = 2;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n;j++){
                if(grid[i][j] == 1){
                    bfs(i,j,markNum++,distance,grid);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n;j++){
                if(distance[i][j] != Integer.MAX_VALUE)
                    maxDistance = Math.max(maxDistance,distance[i][j]);
            }
        }
        return maxDistance == 0 ? -1 : maxDistance;
    }



    public void bfs(int i, int j,int markNum,int[][] distance, int[][] grid){
        //右下左上（顺时针）移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0},{-1,0},{0,-1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j,0});
        int m = grid.length,n = grid[0].length;

        while (!queue.isEmpty()){
            int[] point = queue.poll();
            for(int k = 0; k < 4; k++){
                int nextX = point[0] + next[k][0];
                int nextY = point[1] + next[k][1];
                if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && grid[nextX][nextY] != markNum && grid[nextX][nextY] != 1){
                    grid[nextX][nextY] = markNum; //标记访问
                    //已经大于就没必要继续遍历了
                    if(point[2]+1 > distance[nextX][nextY]){
                        continue;
                    }
                    //是离所有岛屿距离最大
                    distance[nextX][nextY] = point[2]+1;
                    queue.add(new int[]{nextX,nextY,point[2]+1});
                }
            }
        }
    }

    public static void main(String[] args) {
        MaxDistance1162 maxDistance1162 = new MaxDistance1162();
        System.out.println(maxDistance1162.maxDistance(StringTransformUtil.toIntMatrix("\n" +
                "[[1,0,1],[0,0,0],[1,0,1]]")) == 2);

        System.out.println(maxDistance1162.maxDistance(StringTransformUtil.toIntMatrix(
                "[[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]")) == -1);

        System.out.println(maxDistance1162.maxDistance(StringTransformUtil.toIntMatrix(
                "[[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1]]")) == -1);
    }
}

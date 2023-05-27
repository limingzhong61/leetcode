package lmz.algorithm.graph_theory;

import lmz.my.leetcode.TransformUtil;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland695 {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int m = grid.length,n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n;j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea,BFS(i,j,grid));
                }
            }
        }
        return maxArea;
    }

    public int BFS(int i,int j,int[][] grid){
        int cnt = 0;
        //右下左上（顺时针）移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0},{-1,0},{0,-1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        int m = grid.length,n = grid[0].length;
        grid[i][j] = 2; //标记访问
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            cnt++;
            for(int k = 0; k < 4; k++){
                int nextX = point[0] + next[k][0];
                int nextY = point[1] + next[k][1];
                if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                    && grid[nextX][nextY] == 1){
                    grid[nextX][nextY] = 2; //标记访问
                    queue.add(new int[]{nextX,nextY});
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        //int[][] ints = new int[1][0];
        //System.out.println(ints.length);
        //System.out.println(ints[0][0]);
        MaxAreaOfIsland695 maxAreaOfIsland695 = new MaxAreaOfIsland695();
        System.out.println(maxAreaOfIsland695.maxAreaOfIsland
                (TransformUtil.toIntMatrix("[[0,0,1,0,0,0,0,1,0,0,0,0,0]," +
                        "[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0]," +
                        "[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0]," +
                        "[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0]," +
                        "[0,0,0,0,0,0,0,1,1,0,0,0,0]]\n")));
        System.out.println(maxAreaOfIsland695.maxAreaOfIsland
                (TransformUtil.toIntMatrix("[[0,0,1,0,0,0,0,1,0,0,0,0,0]," +
                        "[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0]," +
                        "[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0]," +
                        "[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0]," +
                        "[0,0,0,0,0,0,0,1,1,0,0,0,0]]\n")) == 6);

        System.out.println(maxAreaOfIsland695.maxAreaOfIsland
                (TransformUtil.toIntMatrix("[[0,0,0,0,0,0,0,0]]")));
        System.out.println(maxAreaOfIsland695.maxAreaOfIsland
                (TransformUtil.toIntMatrix("[[0,0,0,0,0,0,0,0]]")) == 0);
    }
}

package codeofli.leetcode.graph_theory;

import codeofli.my.leetcode.TransformUtil;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        int initVal = image[sr][sc];
        //颜色相同不需要染色
        if(color == initVal){
            return image;
        }
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;

        int[][] next = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        int m = image.length, n = image[0].length;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = point[0] + next[i][0];
                int nextY = point[1] + next[i][1];
                if (nextX >= 0 && nextX < m &&
                    nextY >= 0 && nextY < n && image[nextX][nextY] == initVal){
                    image[nextX][nextY] = color;
                    queue.add(new int[]{nextX,nextY});
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        FloodFill733 floodFill733 = new FloodFill733();
        System.out.println(floodFill733.floodFill(TransformUtil.toIntMatrix("[[1,1,1],[1,1,0],[1,0,1]]"), 1, 1, 2));
    }
}

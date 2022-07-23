package codeofli.leetcode.graph_theory;

import codeofli.my.leetcode.StringTransformUtil;
import codeofli.my.util.matrix.MatrixUtil;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {
    /**
     * 从所有的0开始走
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


        public static void main (String[]args){
            UpdateMatrix updateMatrix = new UpdateMatrix();
            MatrixUtil.printMatrix(updateMatrix.updateMatrix(StringTransformUtil.toIntMatrix("[[0,0,0],[0,1,0],[1,1,1]]")));

            MatrixUtil.printMatrix(updateMatrix.updateMatrix(StringTransformUtil.toIntMatrix("[[0,0,0],[1,1,1],[1,1,1]]")));

            MatrixUtil.printMatrix(updateMatrix.updateMatrix(StringTransformUtil.toIntMatrix("[[1,1,0,0,1,0,0,1,1,0],[1,0,0,1,0,1,1,1,1,1],[1,1,1,0,0,1,1,1,1,0],[0,1,1,1,0,1,1,1,1,1]," +
                    "[0,0,1,1,1,1,1,1,1,0],[1,1,1,1,1,1,0,1,1,1],[0,1,1,1,1,1,1,0,0,1],[1,1,1,1,1,0,0,1,1,1],[0,1,0,1,1,0,1,1,1,1],[1,1,1,0,1,0,1,1,1,1]]")));
        }
    }

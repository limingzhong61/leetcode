package codeofli.leetcode.graph_parse_ds.simulation;

import codeofli.my.leetcode.TransformString;

import java.util.Arrays;

public class SpiralOrder29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] res = new int[m * n];
        int row = 0, col = 0,cnt = 0;
        //四周边界
        int left = 0, top = 0, right = n - 1, bottom = m - 1;
        while (true) {
            //从左往右走
            for (int i = left; i <= right; i++) {
                res[cnt++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            //从上往下走
            for (int i = top; i <= bottom; i++) {
                res[cnt++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            //从右往左走
            for (int i = right; i >= left; i--) {
                res[cnt++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            //从下往上走
            for (int i = bottom; i >= top; i--) {
                res[cnt++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
    public int[] spiralOrder1(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] res = new int[m * n];
        int row = 0, col = 0,cnt = 0;
        boolean hasVisited = true;
        while (hasVisited) {
            hasVisited = false;
            //左移
            while(col < n && !visited[row][col]){
                visited[row][col] = true;
                hasVisited = true;
                res[cnt++] = matrix[row][col++];
            }
            //下拐
            col--;
            row++;
            //下移
            while (row < m && !visited[row][col]){
                visited[row][col] = true;
                hasVisited = true;
                res[cnt++] = matrix[row++][col];
            }
            //下拐
            row--;
            col--;
            //右移
            while (col >= 0 && !visited[row][col]){
                visited[row][col] = true;
                hasVisited = true;
                res[cnt++] = matrix[row][col--];
            }
            //上拐
            col++;
            row--;
            //上移
            while (row >= 0 && !visited[row][col]){
                visited[row][col] = true;
                hasVisited = true;
                res[cnt++] = matrix[row--][col];
            }
            //右拐
            row++;
            col++;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralOrder29 spiralOrder29 = new SpiralOrder29();

        System.out.println(Arrays.toString(spiralOrder29.spiralOrder(
                TransformString.toIntMatrix(" [[1,2,3],[4,5,6],[7,8,9]]"))));
        System.out.println(Arrays.equals(spiralOrder29.spiralOrder(
                TransformString.toIntMatrix(" [[1,2,3],[4,5,6],[7,8,9]]")),TransformString.toIntArray("[1,2,3,6,9,8,7,4,5]")));

        System.out.println(Arrays.toString(spiralOrder29.spiralOrder(
                TransformString.toIntMatrix("  [[1,2,3,4],[5,6,7,8],[9,10,11,12]]"))));
        System.out.println(Arrays.equals(spiralOrder29.spiralOrder(
                TransformString.toIntMatrix(" [[1,2,3,4],[5,6,7,8],[9,10,11,12]]")),
                TransformString.toIntArray("[1,2,3,4,8,12,11,10,9,5,6,7]")));

        System.out.println(Arrays.toString(spiralOrder29.spiralOrder(
                TransformString.toIntMatrix("  [[]]"))));
        System.out.println(Arrays.equals(spiralOrder29.spiralOrder(
                TransformString.toIntMatrix("[[]]")),
                TransformString.toIntArray("[]")));

        System.out.println(Arrays.toString(spiralOrder29.spiralOrder(
                TransformString.toIntMatrix("[]"))));
        System.out.println(Arrays.equals(spiralOrder29.spiralOrder(
                TransformString.toIntMatrix("[]")),
                TransformString.toIntArray("[]")));
    }
}

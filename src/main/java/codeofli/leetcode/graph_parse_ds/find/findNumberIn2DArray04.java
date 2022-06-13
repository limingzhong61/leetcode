package codeofli.leetcode.graph_parse_ds.find;

import codeofli.my.leetcode.TransformString;

public class findNumberIn2DArray04 {

    /**
     * leetcode:线性查找
     * 矩阵逆时针旋转 45° ，并将其转化为图形式，发现以右上角为根结点，此时矩阵类似于 二叉搜索树
     * 从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。
     * 如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length,m = matrix[0].length;
        //注意开始从第一列最右边开始matrix[0],即从二维数组的右上角
        int row = 0, col = m - 1;
        while(row < n && col >= 0){
            int num = matrix[row][col];
            if(num == target){
                return true;
            }
            if(num > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
    /**
     * my:记忆化搜索，用一个数组标记访问
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        return find(0, 0, matrix, visited, target);
    }

    private boolean find(int i, int j, int[][] matrix, boolean[][] visited, int target) {
        if (i >= matrix.length || j >= matrix[0].length || visited[i][j]) {
            return false;
        }
        if (matrix[i][j] == target) {
            return true;
        }
        visited[i][j] = true;
        return find(i + 1, j, matrix, visited, target) ||
                find(i, j + 1, matrix, visited, target);
    }

    public static void main(String[] args) {
        findNumberIn2DArray04 find04 = new findNumberIn2DArray04();

        System.out.println(find04.findNumberIn2DArray(TransformString.toIntMatrix("[\n" +
                "  [1,   4,  7, 11, 15],\n" +
                "  [2,   5,  8, 12, 19],\n" +
                "  [3,   6,  9, 16, 22],\n" +
                "  [10, 13, 14, 17, 24],\n" +
                "  [18, 21, 23, 26, 30]\n" +
                "]"), 5));

        System.out.println(find04.findNumberIn2DArray(TransformString.toIntMatrix("[\n" +
                "  [1,   4,  7, 11, 15],\n" +
                "  [2,   5,  8, 12, 19],\n" +
                "  [3,   6,  9, 16, 22],\n" +
                "  [10, 13, 14, 17, 24],\n" +
                "  [18, 21, 23, 26, 30]\n" +
                "]"), 20));

        System.out.println(find04.findNumberIn2DArray(TransformString.toIntMatrix("[]"), 0));
    }
}

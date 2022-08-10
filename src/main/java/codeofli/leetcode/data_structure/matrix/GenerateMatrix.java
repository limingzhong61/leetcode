package codeofli.leetcode.data_structure.matrix;

import codeofli.my.util.matrix.MatrixUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenerateMatrix {
    /**
     * 按层模拟
     * 按照要求，初始位置设为矩阵的左上角，初始方向设为向右。
     * **若下一步的位置超出矩阵边界，或者是之前访问过的位置，则顺时针旋转，进入下一个方向**。
     * 如此反复直至填入$ n^2$个元素。
     */
    public int[][] generateMatrix(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                matrix[top][col] = curNum++;
            }
            for (int row = top+1; row <= bottom; row++) {
                matrix[row][right] = curNum++;
            }
            //可能存在只有一行或者一列的情况
            if(left == right || top == bottom){
                break;
            }
            for (int col = right-1; col >= left; col--) {
                matrix[bottom][col] = curNum++;
            }
            for (int row = bottom-1; row > top; row--) {
                matrix[row][left] = curNum++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return  matrix;
    }

    /**
     * 模拟-非法然后换方向
     * 按照要求，初始位置设为矩阵的左上角，初始方向设为向右。
     * **若下一步的位置超出矩阵边界，或者是之前访问过的位置，则顺时针旋转，进入下一个方向**。
     * 如此反复直至填入$ n^2$个元素。
     */
    public int[][] generateMatrix2(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }

    /**
     * 模拟
     * 点在[left,right][bottom,top]中顺时针移动
     */
    public int[][] generateMatrix1(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        //因为默认前一次遍历，已经遍历了夹角，最开始右移故j=-1,且i因为遍历判断走到了前一格，故i=-1
        int i = -1, j = -1, index = 1;
        while (true) {
            //right move
            for (j++, i++; j <= right; j++) {
                matrix[i][j] = index++;
            }
            if (index == n * n + 1) {
                break;
            }
            // downward move, x==right;
            top++;
            //因为前一个i,j为夹角已经被遍历过了,且j因为遍历判断走到了下一格
            for (i++, j--; i <= bottom; i++) {
                matrix[i][j] = index++;
            }
            if (index == n * n + 1) {
                break;
            }
            // left move, j==bottom;
            right--;
            for (j--, i--; j >= left; j--) {
                matrix[i][j] = index++;
            }
            if (index == n * n + 1) {
                break;
            }
            // upward move, j==bottom;
            bottom--;
            for (i--, j++; i >= top; i--) {
                matrix[i][j] = index++;
            }
            if (index == n * n + 1) {
                break;
            }
            left++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        MatrixUtil.printMatrix(generateMatrix.generateMatrix(3));
        System.out.println(Arrays.deepToString(generateMatrix.generateMatrix(8)));
    }
}

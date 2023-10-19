package com.lmz.leetcode.practice.data_structure.normal.array_and_strings.two_dem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindDiagonalOrder {
    /**
     * leetcode:对角线遍历，加翻转
     */
    /**
     * my:模拟，要点在于边界处理
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        boolean up = true; //起始走向
        int size = row * col;
        int[] result = new int[size];
        int cnt = 0;
        for(int i = 0; i < row; i++){
            ArrayList<Integer> intermediate = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                result[cnt++] = mat[i][j];
            }
            if(!up){ //不是右上方向，则需要翻转
                Collections.reverse(intermediate);
            }
            up = !up; // 方向翻转

        }

        return result;
    }
    /**
     * my:模拟，要点在于边界处理
     */
    public int[] findDiagonalOrder1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i = 0, j = 0; //起始坐标
        boolean up = true; //起始走向
        int size = m * n;
        int[] result = new int[size];
        int cnt = 0;
        while (cnt < size) {
            result[cnt++] = mat[i][j];
            //向右上方走，边界右和上
            if (up) {
                //右边界应该先判断，因为右上角（0,n-1）应该下移
                if (j == n - 1) {//抵达右边界,则下移
                    i++;
                    up = !up;
                } else if (i == 0) { //抵达上边界,则右移
                    j++;
                    up = !up;
                } else {//右上移动
                    i--;
                    j++;
                }
                //向左下方走，边界右和上
            } else {
                if (i == m - 1) { //抵达下边界,则右移
                    j++;
                    up = !up;
                } else if (j == 0) {//抵达左边界,则下移
                    i++;
                    up = !up;
                } else {//左下移动
                    i++;
                    j--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindDiagonalOrder findDiagonalOrder = new FindDiagonalOrder();
        //int[] diagonalOrder = findDiagonalOrder.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        int[] diagonalOrder = findDiagonalOrder.findDiagonalOrder(new int[][]{{1, 2, 3,4}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(diagonalOrder));
    }
}

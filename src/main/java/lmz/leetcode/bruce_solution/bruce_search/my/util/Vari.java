package lmz.leetcode.bruce_solution.bruce_search.my.util;

public class Vari {
    {
        //右下左上（顺时针）的4个方向移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0},{-1,0},{0,-1}
        };}
    {
        //上方向开始（顺时针）的8个方向移动数组
        int[][] next = new int[][]{
                {0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1}
        };
    }
}

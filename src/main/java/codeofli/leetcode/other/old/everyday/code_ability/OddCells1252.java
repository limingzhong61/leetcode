package codeofli.leetcode.other.old.everyday.code_ability;

import codeofli.my.leetcode.TransformUtil;

public class OddCells1252 {
    /**
     *方法三：计数优化
     */
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int oddx = 0, oddy = 0;
        for (int i = 0; i < m; i++) {
            if ((rows[i] & 1) != 0) {
                oddx++;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((cols[i] & 1) != 0) {
                oddy++;
            }
        }
        return oddx * (n - oddy) + (m - oddx) * oddy;
    }

    /**
     * 模拟空间优化
     * 时间复杂度 indices.length + m*n
     * 空间复杂度 O(m+n)
     */
    public int oddCells2(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int[] item : indices){
            rows[item[0]]++;
            cols[item[1]]++;

        }
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if((rows[i] + cols[j]) % 2 == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    /**
     * 直接模拟
     * 时间复杂度 indices.length * max{m,n}
     * 空间复杂度 O(m*n)
     */
    public int oddCells1(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for(int[] item : indices){
            for(int i = 0; i < m; i++){
                matrix[i][item[1]]++;
            }
            for(int j = 0; j < n; j++){
                matrix[item[0]][j]++;
            }
        }
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] % 2 == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        OddCells1252 oddCells1252 = new OddCells1252();
        System.out.println(oddCells1252.oddCells(2, 3, TransformUtil.toIntMatrix("[[0,1],[1,1]]")));
        System.out.println(oddCells1252.oddCells(2, 3, TransformUtil.toIntMatrix("[[0,1],[1,1]]")) == 6);
    }
}

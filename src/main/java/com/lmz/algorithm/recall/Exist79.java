package com.lmz.algorithm.recall;

/**
 * @author: limingzhong
 * @create: 2023-06-16 14:45
 */
public class Exist79 {
    boolean[][] onPath;
    boolean result;
    int m, n;

    /**
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    onPath = new boolean[m][n];
                    dfs(board, word, 0, 0, 0);
                }
            }
        }
        return result;
    }

    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void dfs(char[][] board, String word, int cur, int x, int y) {
        if (result) return;
        if (cur == word.length()) {
            result = true;
        }
        for (int i = 0; i < dir.length; i++) {
            int nextX = x + dir[i][0];
            int nextY = x + dir[i][1];
            if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n &&
            !onPath[nextX][nextY] && board[nextX][nextY] == word.charAt(cur)){
                dfs(board,word,cur,nextX,nextY);
            }
        }
    }
}

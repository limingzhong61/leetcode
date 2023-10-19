package com.lmz.leetcode.practice.graph.traverse;

import com.lmz.algorithm_learning.leetcode.TransformUtil;
import com.lmz.algorithm_learning.util.matrix.MatrixUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solve130 {
    /**
     * 与边相连的点：从边界上的点出发遍历，能遍历到的点都是
     */
    int[][] next = new int[][]{
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        char mark = '-';
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
                board[i][0] = mark;
            }
            if (board[i][n - 1] == 'O') {
                queue.add(new int[]{i, n - 1});
                board[i][n - 1] = mark;
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                queue.add(new int[]{0, i});
                board[0][i] = mark;
            }
            if (board[m - 1][i] == 'O') {
                queue.add(new int[]{m - 1, i});
                board[m - 1][i] = mark;
            }
        }
        //BFS
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            for (var item : next) {
                int nextX = x + item[0];
                int nextY = y + item[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && board[nextX][nextY] == 'O') {
                    queue.add(new int[]{nextX, nextY});
                    board[nextX][nextY] = mark; //标记与边相连
                }
            }
        }
        //'-'为与边相连的点，则’O‘为不与边相连的点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == mark) {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * bfs：找到一格O，然后再判断是否有在半径的O，有则错误，
     * 没有则能用X替换，则重新bfs替换这个O的块
     * <p>
     * m == board.length
     * n == board[i].length
     * 1 <= m, n <= 200
     */
    public void solve1(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) { // 一个已经被访问的是肯定存在一个边界的'O'
                    if (bfs1(board, visited, i, j)) {
                        setX(board, i, j);
                    }
                }
            }
        }
    }


    private boolean bfs1(char[][] board, boolean[][] visited, int x, int y) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        boolean solved = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            x = pos[0];
            y = pos[1];
            for (int i = 0; i < next.length; i++) {
                int nextX = x + next[i][0];
                int nextY = y + next[i][1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (!visited[nextX][nextY] && board[nextX][nextY] == 'O') {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                } else {  //产生越界的x,y肯定是边界点，不能直接return,需要标记其他其他不成立（用visited标记）
                    solved = false;
                }

            }
        }
        return solved;
    }

    private void setX(char[][] board, int x, int y) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        board[x][y] = 'X';
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            x = pos[0];
            y = pos[1];
            if (x <= 0 || x >= m - 1 || y <= 0 || y >= n - 1) {
                continue;
            }
            for (int i = 0; i < next.length; i++) {
                int nextX = x + next[i][0];
                int nextY = y + next[i][1];
                if (board[nextX][nextY] == 'O') {
                    queue.add(new int[]{nextX, nextY});
                    board[nextX][nextY] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        Solve130 solve130 = new Solve130();

        testCase("[[\"X\",\"X\",\"X\"],[\"X\",\"O\",\"X\"],[\"X\",\"X\",\"X\"]]", solve130,
                "[[\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\"]]");

        testCase("[[\"X\",\"O\",\"X\",\"O\",\"X\",\"O\"]," +
                        "[\"O\",\"X\",\"O\",\"X\",\"O\",\"X\"]," +
                        "[\"X\",\"O\",\"X\",\"O\",\"X\",\"O\"]," +
                        "[\"O\",\"X\",\"O\",\"X\",\"O\",\"X\"]]",
                solve130, "[[\"X\",\"O\",\"X\",\"O\",\"X\",\"O\"],[\"O\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\",\"X\",\"O\"]," +
                        "[\"O\",\"X\",\"O\",\"X\",\"O\",\"X\"]]");
        testCase("[[\"O\",\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"O\",\"X\",\"O\"]," +
                        "[\"X\",\"O\",\"X\",\"O\",\"X\"],[\"O\",\"X\",\"O\",\"O\",\"O\"],[\"X\",\"X\",\"O\",\"X\",\"O\"]]",
                solve130, "[[\"O\",\"X\",\"X\",\"O\",\"X\"],[\"X\",\"X\",\"X\",\"X\",\"O\"],[\"X\",\"X\",\"X\",\"O\",\"X\"]," +
                        "[\"O\",\"X\",\"O\",\"O\",\"O\"],[\"X\",\"X\",\"O\",\"X\",\"O\"]]");
        testCase("[[\"X\",\"O\",\"O\",\"X\",\"X\",\"X\",\"O\",\"X\",\"O\",\"O\"],[\"X\",\"O\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\",\"O\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"X\",\"X\",\"X\",\"O\",\"X\",\"X\",\"X\",\"O\"],[\"O\",\"X\",\"X\",\"X\",\"O\",\"X\",\"O\",\"X\",\"O\",\"X\"],[\"X\",\"X\",\"O\",\"X\",\"X\",\"O\",\"O\",\"X\",\"X\",\"X\"],[\"O\",\"X\",\"X\",\"O\",\"O\",\"X\",\"O\",\"X\",\"X\",\"O\"],[\"O\",\"X\",\"X\",\"X\",\"X\",\"X\",\"O\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"O\",\"X\",\"X\",\"O\",\"X\",\"X\",\"O\",\"O\"],[\"X\",\"X\",\"X\",\"O\",\"O\",\"X\",\"O\",\"X\",\"X\",\"O\"]]"
                ,
                solve130, "[[\"X\",\"O\",\"O\",\"X\",\"X\",\"X\",\"O\",\"X\",\"O\",\"O\"],[\"X\",\"O\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"O\"],[\"O\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"O\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"O\"],[\"O\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"O\",\"O\"],[\"X\",\"X\",\"X\",\"O\",\"O\",\"X\",\"O\",\"X\",\"X\",\"O\"]]");
    }

    private static void testCase(String original, Solve130 solve130, String original1) {
        char[][] board = TransformUtil.toCharMatrix(original);
        solve130.solve(board);
        MatrixUtil.printMatrix(board);
        System.out.println(Arrays.deepEquals(board,
                TransformUtil.toCharMatrix(original1)));
    }
}

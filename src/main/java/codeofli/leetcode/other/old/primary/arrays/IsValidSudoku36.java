package codeofli.leetcode.other.old.primary.arrays;

import java.util.Arrays;

public class IsValidSudoku36 {
    /**
     * leetcode:
     * 遍历1次,
     * 9宫格中3*3的小格
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][][] subboxes = new boolean[3][3][9];
        int length = board.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] != '.') {
                    int markNumber = board[i][j] - '0' - 1;
                    if (rows[i][markNumber] || columns[j][markNumber] || subboxes[i / 3][j / 3][markNumber]) {
                        return false;
                    }
                    rows[i][markNumber] = true;
                    // j is column
                    columns[j][markNumber] = true;
                    subboxes[i / 3][j / 3][markNumber] = true;
                }
            }
        }
        return true;
    }

    /**
     * my
     * 遍历3次
     */
    public boolean isValidSudoku1(char[][] board) {
        boolean[] mark = new boolean[11];
        int length = board.length;
        // row judge
        for (int i = 0; i < length; i++) {
            Arrays.fill(mark,false);
            for (int j = 0; j < length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int markNumber = board[i][j] - '0';
                if (mark[markNumber]) {
                    return false;
                }
                mark[markNumber] = true;
            }
        }
        // System.out.println("column judge");
        // column judge
        for (int i = 0; i < length; i++) {
            Arrays.fill(mark,false);
            for (int j = 0; j < length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int markNumber = board[j][i] - '0';
                if (mark[markNumber]) {
                    return false;
                }
                mark[markNumber] = true;
            }
        }
        // System.out.println("3*3 judge");
        // 3*3 judge
        for (int a = 0; a < length; a += 3) {
            for (int b = 0; b < length; b += 3) {
                Arrays.fill(mark,false);
                for (int i = a; i < a + 3; i++) {
                    for (int j = b; j < b + 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        }
                        int markNumber = board[i][j] - '0';
                        if (mark[markNumber]) {
                            return false;
                        }
                        mark[markNumber] = true;
                    }
                }
            }

        }

        return true;
    }
}
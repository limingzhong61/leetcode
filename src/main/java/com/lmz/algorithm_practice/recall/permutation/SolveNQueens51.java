package com.lmz.algorithm_practice.recall.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-06-16 11:33
 */
public class SolveNQueens51 {
    private int n;
    private int[] col;
    private boolean[] onPath, diag1, diag2;
    private final List<List<String>> ans = new ArrayList<>();

    /**
     * 主对角线上： （横坐标-纵坐标）的值固定
     * 副对角线上： 横纵坐标之和固定
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        col = new int[n];
        onPath = new boolean[2 * n - 1];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];

        dfs(0);
        return ans;
    }

    private void dfs(int r) {
        if (r == n) {
            List<String> board = new ArrayList<>(n);
            for (int c : col) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                board.add(new String(row));
            }
            ans.add(board);
            return;
        }
        for (int c = 0; c < n; c++) {
            int rc = r - c + n - 1;
            if (!onPath[c] && !diag1[rc] && !diag2[r + c]) {
                onPath[c] = diag1[rc] = diag2[r+c] = true;
                col[r] = c;
                dfs(r+1);
                onPath[c] = diag1[rc] = diag2[r+c] = false; //恢复现场
            }
        }
    }
}

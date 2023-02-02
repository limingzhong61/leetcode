package lmz.leetcode.other.medium;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-01-21 11:03
 */
public class MinSideJumps1824 {
    /**
     * dp
     * 1 <= n <= 5 * 10^5
     */
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length -1;
        // f[i][j]表示i处j道路到n处的最小侧条数。
        int[][] f = new int[n + 1][4];
        final int maxVal = 5 * (int) (1e5) + 1;
        for (var x : f) {
            Arrays.fill(x,maxVal);
        }
        for (int j = 1; j < 4; j++) {
            if (obstacles[n] != j) {
                f[n][j] = 0;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j < 4; j++) {
                if (obstacles[i] == j) {
                    continue;
                }
                if (obstacles[i + 1] != j) {
                    f[i][j] = Math.min(f[i][j], f[i + 1][j]);
                } else {
                    for (int k = 1; k < 4; k++) {
                        if (k == j) {
                            continue;
                        }
                        if (obstacles[i] != k) {
                            // 不用判断 i+1点k道路是否有障碍，因为有也是为最大值。不会影响结果。
                            f[i][j] = Math.min(f[i][j], f[i+1][k] + 1);
                        }
                    }
                }
            }
        }
        return f[0][2];
    }
}

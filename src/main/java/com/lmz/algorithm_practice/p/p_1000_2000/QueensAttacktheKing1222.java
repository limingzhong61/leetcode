package com.lmz.algorithm_practice.p.p_1000_2000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-09-14 10:19
 */
public class QueensAttacktheKing1222 {

    int[][] next = new int[][]{{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {-1, 1},};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int n = 8;
        List<List<Integer>> ans = new ArrayList<>();
        for (int b = 0; b < 8; b++) {
            int i = next[b][0];
            int j = next[b][1];
            int x = king[0];
            int y = king[0];
            while (true) {
                x += i;
                y += j;
                for (var q : queens) {
                    if (q[0] == x && q[1] == y) {
                        ans.add(List.of(x,y));
                        break;
                    }
                }
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    break;
                }
            }

        }
        return  ans;
    }
}

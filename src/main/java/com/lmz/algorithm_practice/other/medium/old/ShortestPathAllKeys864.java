package com.lmz.algorithm_practice.other.medium.old;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: codeofli
 * @create: 2022-11-10 9:27
 */
public class ShortestPathAllKeys864 {
    /**
     * BFS + 状态压缩
     */
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        //右下左上（顺时针）移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        //<x,y,dist,state>
        Queue<int[]> queue = new LinkedList<>();
        //起点‘@’
        int k = 0,s1 = 0,s2 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    s1 = i;
                    s2 = j;
                } else if (Character.isLowerCase(grid[i].charAt(j))) {
                    k++;
                }
            }
        }
        //钥匙的数目范围是 [1, 6]
        boolean[][][] visited = new boolean[m][n][1 << k];
        visited[s1][s2][0] = true;
        queue.add(new int[]{s1, s2, 0, 0});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1],state = point[3];
            if (state == (1 << k) - 1) {
                return point[2];
            }
            for (var item : next) {
                int nextX = x + item[0];
                int nextY = y + item[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX].charAt(nextY) != '#' && !visited[nextX][nextY][state]) {
                    char charAt = grid[nextX].charAt(nextY);
                    int nextState = state;
                    if (Character.isUpperCase(charAt) && (state & (1 <<( charAt - '0'))) == 0) { // lock
                            continue;
                    }else if (Character.isLowerCase(charAt)) { // key
                        int cIdx = charAt - 'a';
                        nextState |= 1 << cIdx;
                    }
                    visited[nextX][nextY][state] = true;
                    queue.add(new int[]{nextX, nextY, point[2] + 1, nextState});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathAllKeys864 shortestPathAllKeys864 = new ShortestPathAllKeys864();
        //System.out.println(shortestPathAllKeys864.shortestPathAllKeys(TransformUtil.toStringArray("[\"@.a..\",\"###.#\",\"b.test.A.B\"]")));
        System.out.println(shortestPathAllKeys864.shortestPathAllKeys(TransformUtil.toStringArray("[\"@...a\",\".###test.A\",\"b.BCc\"]")));
    }

}

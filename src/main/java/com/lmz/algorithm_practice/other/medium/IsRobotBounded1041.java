package com.lmz.algorithm_practice.other.medium;

/**
 * @author: limingzhong
 * @create: 2023-04-11 22:18
 */
public class IsRobotBounded1041 {
    class Solution {
        public boolean isRobotBounded(String instructions) {
            
            int n = instructions.length();
            var map = new int[n+1][n+1];
            // 北，东，南，西 顺时针
            int[][] next = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int dirCnt = 4;
            int dir = 0;
            int x = 0, y = 0;
            for(int i = 0; i < 4; i++){
                for (char c : instructions.toCharArray()) {
                    if (c == 'R') {
                        dir = (dir + 1) % dirCnt;
                    } else if (c == 'L') {
                        dir = (dir - 1 + dirCnt) % dirCnt;
                    } else { //'G'
                        x += next[dir][0];
                        y += next[dir][1];
                        System.out.printf("%d,%d", x, y);
                        if (map[x][y] == 1) {
                            return true;
                        }
                        map[x][y] = 1;
                    }
                }
            }
            return false;
        }
    }
}

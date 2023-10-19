package com.lmz.leetcode.practice.graph.grid_map;

import java.util.HashMap;
import java.util.Map;

public class AlphabetBoardPath1138 {
    public String alphabetBoardPath(String target) {
        String[] board = new String[]{"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        int n = board.length;
        Map<Character, int[]> locMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                locMap.put(board[i].charAt(j), new int[]{i, j});
            }
        }
        StringBuilder res = new StringBuilder();
        int lastX = 0, lastY = 0;
        for (char c : target.toCharArray()) {
            int[] ints = locMap.get(c);
            int x = ints[0], y = ints[1];
            int xDiff = x - lastX, yDiff = y - lastY;

            // 因为地图中z在最后一行第一个，故先走L，和U
            while (yDiff < 0) {
                res.append('L');
                yDiff++;
            }
            while (xDiff < 0) {
                res.append('U');
                xDiff++;
            }


            while (yDiff > 0) {
                res.append('R');
                yDiff--;
            }
            while (xDiff > 0) {
                res.append('D');
                xDiff--;
            }


            res.append('!');
            lastX = x;
            lastY = y;
        }

        return res.toString();
    }


}

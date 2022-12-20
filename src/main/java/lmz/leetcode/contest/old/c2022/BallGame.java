package lmz.leetcode.contest.old.c2022;

import lmz.my.leetcode.TransformUtil;

import java.util.*;

public class BallGame {
    //右下左上（顺时针）移动数组
    final int[][] nexts = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    /**
     * 从边缘开始
     */
    public int[][] ballGame(int num, String[] plate) {
        //1 <= plate.length, plate[i].length <= 1000
        int m = plate.length;
        int n = plate[0].length();
        int x = 0, y = 0;
        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet();
        int rows = m;
        int cols = n;
        num--;
        for (int i = 1; i < m - 1; i++) {
            if (plate[i].charAt(0) == '.') {
                queue.add(new int[]{i, 0, num, 0, i, 0});
                set.add(get(i, 0, 0));
            }
            if (plate[i].charAt(cols - 1) == '.') {
                queue.add(new int[]{i, cols - 1, num, 2, i, cols - 1});
                set.add(get(i, cols - 1, 2));
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (plate[0].charAt(i) == '.') {
                queue.add(new int[]{0, i, num, 1, 0, i});
                set.add(get(0, i, 1));
            }
            if (plate[rows - 1].charAt(i) == '.') {
                queue.add(new int[]{rows - 1, i, num, 3, rows - 1, i});
                set.add(get(rows - 1, i, 3));
            }
        }
        List<int[]> res = new ArrayList<>();
        HashSet<Integer> posSet = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            if (pos[2] < 0) {
                continue;
            }
            x = pos[0];
            y = pos[1];
            int i = pos[3];
            int k = i;
            int nextX = pos[0] + nexts[k][0];
            int nextY = pos[1] + nexts[k][1];
            if (checkRange(0, rows, nextX) && checkRange(0, cols, nextY)
            ) {
                if (plate[nextX].charAt(nextY) == 'W') {
                    k = (i - 1 + 4) % 4;
                } else if (plate[nextX].charAt(nextY) == 'E') {
                    k = (i + 1) % 4;
                }
                if (set.contains(get(nextX, nextY, k))) {
                    continue;
                }
                queue.add(new int[]{nextX, nextY, pos[2] - 1, k, pos[4], pos[5]});
                if (plate[nextX].charAt(nextY) == 'O') {
                    int code = nextX * 1000 + nextY;
                    if(!posSet.contains(code)){
                        posSet.add(code);
                    res.add(new int[]{pos[4], pos[5]});
                    }
                }
            }
        }
        return res.toArray(new int[0][]);
    }

    int get(int x, int y, int dir) {
        int base = 1000;
        return x * base * 10 + y * 10 + dir;
    }

    /**
     * 校验x是否是在 [start,end)中
     *
     * @param start
     * @param end
     * @param num
     * @return
     */
    public boolean checkRange(int start, int end, int num) {
        return num >= start && num < end;
    }

    public static void main(String[] args) {
        BallGame ballGame = new BallGame();
        //System.out.println(Arrays.deepToString(ballGame.ballGame(4, TransformUtil.toStringArray("[\"..E.\",\".EOW\",\"..W.\"]"))));
        System.out.println(Arrays.deepToString(ballGame.ballGame(3, TransformUtil.toStringArray("[\".....\",\"....O\",\"....O\",\".....\"]"))));
    }
}

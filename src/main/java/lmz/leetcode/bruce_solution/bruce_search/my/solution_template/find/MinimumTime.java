package lmz.leetcode.bruce_solution.bruce_search.my.solution_template.find;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: limingzhong
 * @create: 2023-02-26 11:28
 */
public class MinimumTime {
    final int[][] nexts = new int[][]{
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };

    public int minimumTime(int[][] grid) {
        // <t,x,y>
        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] = b[0]);

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        q.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        for (int[] next : nexts) {
            int nextX = 0 + next[0];
            int nextY = 0 + next[1];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                pq.add(new int[]{grid[nextX][nextY], nextX, nextY});
            }
        }
        int nowT = 1;
        while (true) {
            int x = nowT;
            if (!pq.isEmpty()) {
                x = Math.min(pq.peek()[0], nowT);
            }
            int size = q.size();

            PriorityQueue<int[]> temp = new PriorityQueue<>((a, b) -> a[0] = b[0]);

            while (!pq.isEmpty() && pq.peek()[0] <= x) {
                int[] top = pq.poll();
                if (top[1] == m - 1 && top[2] == n - 1) {
                    return nowT;
                }
                q.add(new int[]{nowT, top[1], top[2]});
                visited[0][0] = true;
                for (int[] next : nexts) {
                    int nextX = top[1] + next[0];
                    int nextY = top[2] + next[1];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        temp.add(new int[]{grid[nextX][nextY], nextX, nextY});
                    }
                }
            }
            while(!temp.isEmpty()){
                pq.add(temp.poll());
            }

            if (q.size() == size) { // 没法移动
                return -1;
            }
            nowT++;
        }

    }

    public static void main(String[] args) {
        MinimumTime minimumTime = new MinimumTime();
        System.out.println(minimumTime.minimumTime(TransformUtil.toIntMatrix("[[0,1,3,2],[5,1,2,5],[4,3,8,6]]")));
    }
}

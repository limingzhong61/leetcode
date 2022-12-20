package lmz.leetcode.contest.c322;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class minScore {
    public int minScore(int n, int[][] roads) {
        //2 <= n <= 10^5
        //边的集合转换为邻接表
        ArrayList<int[]>[] adjList = new ArrayList[n + 1];
        for (int i = 0; i <= n; ++i) {
            adjList[i] = new ArrayList<int[]>();
        }
        for (var edge : roads) {
            adjList[edge[0]].add(new int[]{edge[1], edge[2]});
            adjList[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        //BFS
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, Integer.MAX_VALUE});
        visited[1] = true; //标记访问
        int minDist = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int v = poll[0];
            for (int[] edge : adjList[v]) {
                minDist = Math.min(minDist, edge[1]);
                int w = edge[0];
                if (!visited[w]) {
                    visited[w] = true; //标记访问
                    queue.add(edge);
                }
            }
        }
        return minDist;
    }

}

package com.lmz.algorithm_practice.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanVisitAllRooms841 {

    /**
     * 只需要一次BFS
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //2 <= n <= 1000
        int maxArea = 0;
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        //BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true; //标记访问
        while (!queue.isEmpty()) {
            int v = queue.poll();
            n--;
            for (int w : rooms.get(v)) {
                if (!visited[w]) {
                    visited[w] = true; //标记访问
                    queue.add(w);
                }
            }
        }
        return n == 0;
    }

}

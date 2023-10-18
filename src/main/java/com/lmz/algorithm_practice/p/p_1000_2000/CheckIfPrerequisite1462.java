package com.lmz.algorithm_practice.p.p_1000_2000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: limingzhong
 * @create: 2023-09-13 9:37
 */
public class CheckIfPrerequisite1462 {
    /**
     * 稠密图
     * 0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
     */
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] g = new boolean[numCourses][numCourses];
        for (int[] request : prerequisites) {
            g[request[1]][request[0]] = true;
        }
        List<Boolean> ans = new ArrayList<>(numCourses);
        for (int[] query : queries) {
            int start = query[1], end = query[0];
            boolean[] visited = new boolean[numCourses];
            visited[start] = true;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(start);
            while (!q.isEmpty()) {
                int u = q.poll();
                if (u == end) break;
                for (int v = 0; v < numCourses; v++) {
                    if (!visited[v] && g[u][v]) {
                        visited[v] = true;
                        q.add(v);
                    }
                }
            }
            ans.add(visited[end]);
        }
        return ans;
    }
}

package com.lmz.leetcode.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: codeofli
 * @create: 2022-12-19 10:16
 */
public class ValidPath1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //2 <= n <= 10^5
        //边的集合转换为邻接表
        ArrayList<Integer>[] adjList = getAdjList(n, edges);
        //BFS
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true; //标记访问
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : adjList[v]) {
                if (!visited[w]) {
                    if (w == destination) {
                        return true;
                    }
                    visited[w] = true; //标记访问
                    queue.add(w);
                }
            }
        }
        return false;
    }

    /**
     * 边条件转换为邻接表
     *
     * @param n
     * @param edges
     * @return
     */
    private static ArrayList<Integer>[] getAdjList(int n, int[][] edges) {
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (var edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        return adjList;
    }
}

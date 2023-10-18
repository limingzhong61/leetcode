package com.lmz.algorithm_practice.contest.old.c305;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ReachableNodes2368 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        //边的集合转换为邻接表
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (var edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        boolean[] map = new boolean[n];
        for(int item : restricted){
            map[item] = true;
        }
        //BFS
        boolean[] visited = new boolean[n];
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true; //标记访问
        cnt = 1;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : adjList[v]) {
                if (!visited[w] && !map[w]) {
                    visited[w] = true; //标记访问
                    cnt++;
                    queue.add(w);
                }
            }
        }
        return  cnt;
    }
}

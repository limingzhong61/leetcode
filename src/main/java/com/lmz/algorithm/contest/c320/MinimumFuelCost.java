package com.lmz.algorithm.contest.c320;

import java.util.*;

public class MinimumFuelCost {
    HashMap<Integer, Integer> cntMap = new HashMap<>();
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        //2 <= n <= 10^5
        int[] outDegree = new int[n];
        //边的集合转换为邻接表
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }
        // 无向图
        for (var edge : roads) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
            outDegree[edge[0]]++;
            outDegree[edge[1]]++;
        }
        //BFS
        boolean[] visited = new boolean[n];
        dfs(adjList,0,visited);
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited,false);
        queue.add(0);
        visited[0] = true;
        long res = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int v = poll;

            for (int w : adjList[v]) {
                if (!visited[w]) {
                    visited[w] = true; //标记访问
                    queue.add(w);
                    int peopleCnt = cntMap.getOrDefault(w, 0);
                    if (peopleCnt % seats == 0) {
                        res += peopleCnt / seats;
                    } else {
                        res += peopleCnt / seats + 1;
                    }
                }
            }
        }
        System.out.println("-------");
        return res;
    }
    private int dfs(ArrayList<Integer>[] adjList, int v,boolean[] visited) {
        visited[v] = true;
        int sum = 1;
        for (int w : adjList[v]) {
            if(!visited[w]){
                dfs(adjList,w,visited);
                sum += cntMap.get(w);
            }
        }
        cntMap.put(v,sum);
        System.out.printf("%d,%d\n",v,cntMap.get(v));
        return 0;
    }

    public long minimumFuelCost2(int[][] roads, int seats) {
        int n = roads.length + 1;
        //2 <= n <= 10^5
        int[] outDegree = new int[n];
        //边的集合转换为邻接表
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }
        // 无向图
        for (var edge : roads) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
            outDegree[edge[0]]++;
            outDegree[edge[1]]++;
        }
        //BFS
        boolean[] visited = new boolean[n];
        long res = 0L;
        HashMap<Integer, Integer> cntMap = new HashMap<>();

        // <loc,peopleCnt>
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            //出度=1且不为i!=0
            if (outDegree[i] == 1) {
                queue.add(new int[]{i, 1});
                cntMap.put(i, cntMap.getOrDefault(i, 0) + 1);
                System.out.println(i);
                visited[i] = true; //标记访问
            }
        }
        System.out.println("------");
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int v = poll[0];
            int peopleCnt = cntMap.getOrDefault(poll[0], 0);
            for (int w : adjList[v]) {
                if (w == 0) {
                    if (poll[1] % seats == 0) {
                        res += peopleCnt / seats;
                    } else {
                        res += peopleCnt / seats + 1;
                    }
                    break;
                }
                if (!visited[w]) {
                    visited[w] = true; //标记访问
                    queue.add(new int[]{w, poll[1] + 1});
                    if (peopleCnt % seats == 0) {
                        res += peopleCnt / seats;
                    } else {
                        res += peopleCnt / seats + 1;
                    }
                }else{ // 访问过，人数加一
                    cntMap.put(w, cntMap.getOrDefault(w, 0) + 1);
                }
            }
        }
        return res;
    }


    /**
     * 从入度为0得开始（因为是有向无环图，则肯定有入度为0的点）
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        //2 <= n <= 10^5
        int[] inDegree = new int[n];
        //边的集合转换为邻接表
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (var edge : edges) {
            adjList[edge.get(0)].add(edge.get(1));
            inDegree[edge.get(1)]++;
        }
        //BFS
        boolean[] visited = new boolean[n];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //入度=0
            if (inDegree[i] == 0) {
                res.add(i);
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true; //标记访问
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int w : adjList[v]) {
                        if (!visited[w]) {
                            visited[w] = true; //标记访问
                            queue.add(w);
                        }
                    }
                }
            }
        }
        return res;
    }
}

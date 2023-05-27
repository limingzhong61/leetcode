package lmz.algorithm.contest.c322;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class magnificentSets {
    public int magnificentSets(int n, int[][] edges) {
        //边的集合转换为邻接表
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        var link = new boolean[n+1][n+1];
        for (int i = 0; i <= n; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (var edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
            link[edge[0]][edge[1]] = true;
            link[edge[1]][edge[0]] = true;
        }

        int res = -1;
        for (int i = 1; i <= n; i++) {
            //BFS
            boolean[] visited = new boolean[n+1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true; //标记访问
            int deep = 1;
            boolean success = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                ArrayList<Integer> pointList = new ArrayList<>();
                for(int j = 0; j < size; j++){
                    int v = queue.poll();
                    for(var w : pointList){
                        if(link[v][w]){
                            success = false;
                            break;
                        }
                    }
                    pointList.add(v);
                    for (int w : adjList[v]) {
                        if (!visited[w]) {
                            visited[w] = true; //标记访问
                            queue.add(w);
                        }
                    }
                }
                if(!success){
                    break;
                }
                deep++;
            }
            if(success){
                res = deep;
                System.out.printf("%d,%d\n",res,i);
            }
        }
        return res;
    }
}

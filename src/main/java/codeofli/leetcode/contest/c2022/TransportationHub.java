package codeofli.leetcode.contest.c2022;

import codeofli.my.leetcode.TransformUtil;

import java.util.*;

public class TransportationHub {
    public int transportationHub(int[][] path) {
        //1 <= path.length <= 1000
        int n = path.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(path[i][0]);
            set.add(path[i][1]);
        }
        int size = set.size();
        //0 <= path[i][0], path[i][1] <= 1000
        int N = 1001;
        int[] outDegree = new int[N];
        int[] inDegree = new int[N];
        //边的集合转换为邻接表
        ArrayList<Integer>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (var edge : path) {
            //逆置有向图方向
            adjList[edge[1]].add(edge[0]);
            outDegree[edge[0]]++;
            inDegree[edge[1]]++;

        }
        for (int i = 0; i < N; i++) {
            if(set.contains(i) && inDegree[i] == size - 1 && outDegree[i] == 0){
                return i;
            }
        }
        return  -1;
        //boolean hasZero = false;
        //for (int i = 0; i < N; i++) {
        //    if (outDegree[i] == 0) {
        //        boolean[] visited = new boolean[N];
        //        Queue<Integer> queue = new LinkedList<>();
        //        queue.add(i);
        //        visited[i] = true; //标记访问
        //        int visitedCnt = 0;
        //        while (!queue.isEmpty()) {
        //            int v = queue.poll();
        //            visitedCnt++;
        //            for (int w : adjList[v]) {
        //                if (!visited[w]) {
        //                    visited[w] = true; //标记访问
        //                    queue.add(w);
        //                }
        //            }
        //        }
        //        if(visitedCnt == size){
        //            return i;
        //        }
        //    }
        //}
        //return -1;
    }

    public static void main(String[] args) {
        TransportationHub transportationHub = new TransportationHub();
        System.out.println(transportationHub.transportationHub(TransformUtil.toIntMatrix("[[0,1],[0,3],[1,3],[2,0],[2,3]]")));
        System.out.println(transportationHub.transportationHub(TransformUtil.toIntMatrix("[[0,3],[1,3],[4,0],[2,0],[2,4]]")));
    }
}

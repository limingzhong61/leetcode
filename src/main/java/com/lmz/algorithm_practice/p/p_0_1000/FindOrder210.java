package com.lmz.algorithm_practice.p.p_0_1000;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: limingzhong
 * @create: 2023-09-10 9:58
 */
public class FindOrder210 {
    /**
     * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
     * 稠密图：直接用 邻接表
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] g = new boolean[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        for(int[] x : prerequisites){
            g[x[1]][x[0]] = true;
            inDegree[x[0]]++;
        }
        int[] ans = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        int idx = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
                visited[i] = true;
            }
        }
        while(!q.isEmpty()){
            int u = q.poll();
            ans[idx++] = u;
            for(int i = 0; i < numCourses; i++){
                if(g[u][i]){
                    inDegree[i]--;
                    if(!visited[i] && inDegree[i] == 0){
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }
        if(idx == numCourses){
            return  ans;
        }
        return new int[]{};
    }
}

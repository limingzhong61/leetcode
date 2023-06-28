package lmz.algorithm.graph.topological_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author: limingzhong
 * @create: 2023-06-28 13:48
 */
public class CanFinish207 {
    /**
     * 拓扑排序:
     * 核心要点： 只有入度为0的才能开始
     *      队列遍历，完成v之后，会对它对应所有能到达的结点入度减1
     * 1 <= numCourses <= 10^5
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        int[] inDegree = new int[numCourses];
        for(int[] x : prerequisites){
            adj[x[0]].add(x[1]);
            inDegree[x[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[numCourses];
        // 添加入度为0的
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }

        int cnt = 0;

        while(!q.isEmpty()){
            int v = q.poll();
            cnt++;
            for(int w : adj[v]){
                // 完成v之后，会对它对应所有能到达的结点入度减1
                inDegree[w]--;
                // 只有入度为0，才能开始
                if(!visited[w] && inDegree[w] == 0){
                    visited[w] = true;
                    q.add(w);
                }
            }
        }
        return  cnt == numCourses;
    }
}

package lmz.my.solution_template.graph_theory.traverse.adjacent_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class AdjacentMatrixBFS {


    public int findCircleNum(int[][] isConnected) {
        //1 <= n <= 200
        int cnt = 0;
        int vertexCnt = isConnected.length;
        boolean[] visited = new boolean[vertexCnt];
        for (int i = 0; i < vertexCnt; i++) {
            if (!visited[i]) {
                bfs(i, isConnected, visited);
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * BFS
     *
     * @param u           入点
     * @param isConnected 邻接矩阵版
     * @param visited
     * @return
     */
    public void bfs(int u, int[][] isConnected, boolean[] visited) {
        //BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true; //标记访问
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w = 0; w < isConnected[v].length; w++) {
                if (isConnected[v][w] ==  1 && !visited[w]) {
                    visited[w] = true; //标记访问
                    queue.add(w);
                }
            }
        }
    }
}

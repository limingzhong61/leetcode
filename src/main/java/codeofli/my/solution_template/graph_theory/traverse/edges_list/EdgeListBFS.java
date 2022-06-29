package codeofli.my.solution_template.graph_theory.traverse.edges_list;

import java.util.*;

public class EdgeListBFS {
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

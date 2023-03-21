package lmz.my.solution_template.graph_theory.traverse.adjacent_matrix;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DFSFindAllPaths {
    /**
     * leetcode:因为本题中的图为有向无环图（DAG），搜索过程中不会反复遍历同一个点，因此我们无需判断当前点是否遍历过。
     */
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }


    /**
     * DFS
     */
    public List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
        //2 <= n <= 15
        int n = graph.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, visited, graph, path, res);
        return res;
    }

    private void dfs(int x, boolean[] visited, int[][] graph, List<Integer> path, List<List<Integer>> res) {
        if (x == graph.length-1) {
            res.add(new ArrayList<>(path));
            return;
        }
        visited[x] = true;
        for (int i = 0; i < graph[x].length; i++) {
            if (!visited[graph[x][i]]) {
                path.add(graph[x][i]);
                dfs(graph[x][i], visited, graph, path, res);
                path.remove(path.size() - 1);
            }
        }
        visited[x] = false;
    }
}

package lmz.algorithm.graph.short_path_no_weight;

import lmz.algorithm.data_structure.tree.binary_tree.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AmountOfTime6154 {
    /**
     * 树中节点的数目在范围 [1, 105] 内
     * 1 <= Node.val <= 10^5
     * 每个节点的值 互不相同
     */
    int max = 0;

    public int amountOfTime(TreeNode root, int start) {
        int N = 10001;
        List<List<Integer>> graph = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        //遍历构建图
        dfs(root, graph);
        //BFS求最短路径
        boolean[] visited = new boolean[max + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true; //标记访问
        int time = 0;
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int v = pair[0];
            time = Math.max(time,pair[1]);
            for (int w : graph.get(v)) {
                if (!visited[w]) {
                    visited[w] = true; //标记访问
                    queue.add(new int[]{w, pair[1] + 1});
                }
            }
        }
        return time;
    }

    private void dfs(TreeNode root, List<List<Integer>> graph) {
        //树中节点的数目在范围 [1, 105] 内
        max = Math.max(max, root.val);
        if (root.left != null) {
            graph.get(root.val).add(root.left.val);
            graph.get(root.left.val).add(root.val);
            dfs(root.left, graph);
        }
        if (root.right != null) {
            graph.get(root.val).add(root.right.val);
            graph.get(root.right.val).add(root.val);
            dfs(root.right, graph);
        }
    }
}

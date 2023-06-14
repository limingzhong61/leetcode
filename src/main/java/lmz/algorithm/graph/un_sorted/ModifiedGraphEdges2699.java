package lmz.algorithm.graph.un_sorted;

import lmz.my.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-06-09 9:43
 */
public class ModifiedGraphEdges2699 {
    int target;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        ArrayList<int[]>[] adj = toAdjInUndirectedGraph(edges, n);
        boolean visited[] = new boolean[n];
        this.target = target;
        dfs(adj, source, destination, visited, 0, 0, new ArrayList<int[]>());

        // BFS



        if(!find) return new int[0][0];

        HashMap<String, Integer> map = new HashMap<>();
        for (var x : record) {
            map.put(x[0] + "-" + x[1], x[2]);
        }
        for (var x : edges) {
            String key = x[0] + "-" + x[1];
            if (map.containsKey(key)){
                x[2] = map.get(key);
            }
            if(x[2] < 0){ // 其余边也修改为正数
                x[2] = 1;
            }
        }
        return edges;
    }

    ArrayList<int[]> record = new ArrayList<>();
    boolean find;

    private void dfs(ArrayList<int[]>[] adj, int source, int destination, boolean[] visited, int sum, int cnt, ArrayList<int[]> res) {
        if (visited[source]) return;
        visited[source] = true;

        if (destination == source) {
            if (target - sum >= cnt) {
                if(res.size() > 0 || target == sum){
                    find = true;
                }
                if(res.size() == 0) return;

                record = new ArrayList<>(res.size());
                record.addAll(res);
                record.get(0)[2] = target - sum - cnt + 1;
                for (int i = 1; i < record.size(); i++) {
                    record.get(i)[2] = 1;
                }
                return;
            }
        }
        for (var x : adj[source]) {
            int v = x[0], w = x[1];
            if (w != -1) {
                sum += w;
            } else {
                cnt++;
                res.add(new int[]{source, x[0], x[1]});
            }

            dfs(adj, v, destination, visited, sum, cnt, res);
            if (w != -1) { //恢复现场
                sum -= w;
            } else {
                cnt--;
                res.remove(res.size() - 1);
            }

        }
        visited[source] = false; //恢复现场
    }

    /**
     * 将无向图带权重的边集合转换为 带权重的邻接表
     *
     * @param edges 无向图的边集合,[顶点v1,顶点v2,边权重w3]
     * @param n
     * @return 带权重的邻接表, 其中每一个节点为int[], int[0]为顶点，int[1]为权重
     */
    public static ArrayList<int[]>[] toAdjInUndirectedGraph(int[][] edges, int n) {
        ArrayList<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) { // 不能用for-each遍历因为，adj[i]都是null，不能赋值
            adj[i] = new ArrayList<int[]>();
        }
        for (var x : edges) {
            adj[x[0]].add(new int[]{x[1], x[2]});
            adj[x[1]].add(new int[]{x[0], x[2]});
        }
        return adj;
    }

    public static void main(String[] args) {
        ModifiedGraphEdges2699 modifiedGraphEdges2699 = new ModifiedGraphEdges2699();
        System.out.println(Arrays.deepToString(modifiedGraphEdges2699.modifiedGraphEdges(5,
                TransformUtil.toIntMatrix("[[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]]"), 0, 1, 5)));
        System.out.println(Arrays.deepToString(modifiedGraphEdges2699.modifiedGraphEdges(5,
                TransformUtil.toIntMatrix("[[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]]"), 0, 1, 5)));
    }

}

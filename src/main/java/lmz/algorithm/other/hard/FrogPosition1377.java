package lmz.algorithm.other.hard;

import lmz.my.leetcode.TransformUtil;
import lmz.my.util.Pair;

import java.util.*;

/**
 * @author: limingzhong
 * @create: 2023-05-24 9:34
 */
public class FrogPosition1377 {
    /**
     * 无向树
     *  t 秒后必须在 target（恰好到达，或者 target 是叶子停在原地）
     */
    public double frogPosition(int n, int[][] edges, int t, int target) {
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            adj[i] = new ArrayList<Integer>();
        }

        for (var x : edges) {
            adj[x[0]].add(x[1]);
            adj[x[1]].add(x[0]);
        }
        adj[1].add(1); // 统一为 所有节点的子节点都是 size() - 1
        // bfs
        Queue<Pair<Integer, Double>> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int[] cnt = new int[n + 1];
        Pair<Integer, Double> pair = new Pair<>(1, 1.0);
        q.add(pair);
        cnt[1] = 0;
        visited[1] = true;
        while (!q.isEmpty()) {
            Pair<Integer, Double> poll = q.poll();
            int v = poll.val1;
            double y = poll.val2;
            // t 秒后必须在 target（恰好到达，或者 target 是叶子停在原地）
            if(v == target && ( cnt[v] == t || adj[v].size() == 1)){
                return y;
            }
            if(cnt[v] == t) continue;
            for (var x : adj[v]) {
                if (!visited[x]) {
                    visited[x] = true;
                    double pro = y / (adj[v].size() - 1);
                    cnt[x] = cnt[v] + 1;
                    pair = new Pair<>(x, pro);
                    q.add(pair);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FrogPosition1377 f = new FrogPosition1377();
        System.out.println(f.frogPosition(7, TransformUtil.toIntMatrix("[[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]]"), 1, 7));
    }
}

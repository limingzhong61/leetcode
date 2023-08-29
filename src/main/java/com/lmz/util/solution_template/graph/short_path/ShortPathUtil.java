package com.lmz.util.solution_template.graph.short_path;

import java.util.Arrays;

/**
 * 有向图的最短路径
 * @author: limingzhong
 * @create: 2023-07-18 16:16
 */
public class ShortPathUtil {
    /**
     * 有向图
     * Dijkstra 算法
     */
    static class Dijkstra {
        private static final int INF = Integer.MAX_VALUE / 2;    // 防止更新最短路时加法溢出
        //0 <= edges.length <= n * (n - 1),有可能是稠密图
        int[][] g;
        int n;

        public Dijkstra(int n, int[][] edges) {
            this.n = n;
            g = new int[n][n];  // 邻接矩阵（初始化为无穷大，表示 i 到 j 没有边）
            for (int i = 0; i < n; ++i)
                Arrays.fill(g[i], INF);
            for (int[] x : edges) {
                g[x[0]][x[1]] = x[2];   // 添加一条边（输入保证没有重边）
            }
        }

        public void addEdge(int[] edge) {
            g[edge[0]][edge[1]] = edge[2];   // 添加一条边（输入保证这条边之前不存在）
        }
        // 朴素 Dijkstra 算法
        public int shortestPath(int start, int end) {
            int[] dis = new int[n]; // 从 start 出发，到各个点的最短路，如果不存在则为无穷大
            Arrays.fill(dis, INF);
            dis[start] = 0; // 自己到自己为0
            boolean[] visited = new boolean[n];

            while (true) {

                // 选出还没用于更新的节点v[]中，start到v[]中最小的一条路径的节点x
                // 找到当前最短路，去更新它的邻居的最短路
                // 根据数学归纳法，dis[x] 一定是最短路长度
                int x = -1;
                for (int i = 0; i < n; i++) {
                    if (!visited[i] && (x < 0 || dis[x] > dis[i])) {
                        x = i;
                    }
                }
                if(x < 0 || dis[x] == INF){ //  不能在选出新的边,选出的边已经无法更新;即所有从 start 能到达的点都被更新了
                    return -1;
                }
                if(x == end){  // 找到终点，提前退出
                    return dis[x];
                }

                visited[x] = true;  // 标记，在后续的循环中无需反复更新 x 到其余点的最短路长度
                //用x更新其余边
                for(int y = 0; y < n; y++){
                    dis[y] = Math.min(dis[y],dis[x] + g[x][y]);
                }
            }

        }
    }

    /**
     * 有向图
     * Floyd 算法
     */
    class Floyd {
        private static final int INF = Integer.MAX_VALUE / 3; // 防止更新最短路时加法溢出
        //0 <= edges.length <= n * (n - 1),有可能是稠密图
        int[][] g;
        int n;

        public Floyd(int n, int[][] edges) {
            this.n = n;
            g = new int[n][n];  // 邻接矩阵（初始化为无穷大，表示 i 到 j 没有边）
            for (int i = 0; i < n; ++i) {
                Arrays.fill(g[i], INF);
                g[i][i] = 0;
            }
            for (var e : edges)
                g[e[0]][e[1]] = e[2]; // 添加一条边（输入保证没有重边和自环


            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                    }
                }
            }
        }

        public void addEdge(int[] edge) {
            int x = edge[0], y = edge[1], w = edge[2], n = g.length;
            if (w >= g[x][y]) // 无需更新
                return;
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    g[i][j] = Math.min(g[i][j], g[i][x] + w + g[y][j]);

        }

        public int shortestPath(int start, int end) {
            int ans = g[start][end];
            return ans == INF  ? -1 : ans;
        }

    }
}

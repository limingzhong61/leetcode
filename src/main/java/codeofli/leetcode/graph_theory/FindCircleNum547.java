package codeofli.leetcode.graph_theory;

import codeofli.my.leetcode.StringTransformUtil;

import java.util.LinkedList;
import java.util.Queue;

public class FindCircleNum547 {
    /**
     * 并查集
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {

        int vertexCnt = isConnected.length;

        int[] parent = new int[vertexCnt]; //节点x的根节点是parent[x]
        //置每个结点的父节点初始为他自身
        for (int i = 0; i < vertexCnt; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < vertexCnt; i++) {
            for (int j = 0; j < vertexCnt; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < vertexCnt; i++) {
            if (parent[i] == i) {
                cnt++;
            }
        }
        return cnt;
    }

    private void union(int[] parent, int i, int j) {
        int rootJ = find(parent, j);
        int rootI = find(parent, i);
        parent[rootI] = rootJ;
    }

    /**
     * 找到j的根节点
     *
     * @param parent //* @param root
     */
    private int find(int[] parent, int j) {
        int root = j;
        while (parent[root] != root) {
            root = parent[root];
        }
        while (parent[j] != j) {
            int tempJ = j;
            j = parent[j];
            parent[tempJ] = root; //归并为一次查找就行了
        }
        return root;
    }

    public int findCircleNum1(int[][] isConnected) {
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
                if (isConnected[v][w] == 1 && !visited[w]) {
                    visited[w] = true; //标记访问
                    queue.add(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        FindCircleNum547 findCircleNum547 = new FindCircleNum547();
        System.out.println(findCircleNum547.findCircleNum(StringTransformUtil.toIntMatrix("[[1,1,0],[1,1,0],[0,0,1]]")));
        System.out.println(findCircleNum547.findCircleNum(StringTransformUtil.toIntMatrix("[[1,1,0],[1,1,0],[0,0,1]]")) == 2);

        System.out.println(findCircleNum547.findCircleNum(StringTransformUtil.toIntMatrix("[[1,0,0],[0,1,0],[0,0,1]]")));
        System.out.println(findCircleNum547.findCircleNum(StringTransformUtil.toIntMatrix("[[1,0,0],[0,1,0],[0,0,1]]")) == 3);
    }
}

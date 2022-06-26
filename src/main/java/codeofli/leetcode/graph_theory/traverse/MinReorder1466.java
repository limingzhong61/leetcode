package codeofli.leetcode.graph_theory.traverse;

import codeofli.my.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinReorder1466 {
    /**
     * bfs
     * 多用一个反向的有向图找到0能到达的点集合即可
     */
    public int minReorder(int n, int[][] connections) {
        //2 <= n <= 5 * 10^4
        //边的集合转换为邻接表
        ArrayList<Integer>[] list = new ArrayList[n];
        ArrayList<Integer>[] reverseList = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            list[i] = new ArrayList<Integer>();
            reverseList[i]= new ArrayList<Integer>();
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        for (int[] edge : connections) {
            list[edge[0]].add(edge[1]);
            //便于找到0能到达点的集合
            reverseList[edge[1]].add(edge[0]);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : reverseList[v]) { // 能不改变线路直接到达0点的集合
                if (!visited[w]) {
                    visited[w] = true; //标记访问
                    queue.add(w);
                }
            }
            for (int w : list[v]) { // 需要改变线路直接到达0点的集合
                if (!visited[w]) { //需要更改方向的结点
                    visited[w] = true; //标记访问
                    cnt++;
                    queue.add(w);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        MinReorder1466 minReorder1466 = new MinReorder1466();

        testCase(minReorder1466, 6, "[[0,1],[1,3],[2,3],[4,0],[4,5]]", 3);

        testCase(minReorder1466, 5, "[[1,0],[1,2],[3,2],[3,4]]", 2);
        testCase(minReorder1466, 3, "[[1,0],[2,0]]", 0);
    }

    private static void testCase(MinReorder1466 minReorder1466, int i, String s, int i2) {
        System.out.println(minReorder1466.minReorder(i, TransformUtil.toIntMatrix(s)));
        System.out.println(minReorder1466.minReorder(i, TransformUtil.toIntMatrix(s)) == i2);
    }
}

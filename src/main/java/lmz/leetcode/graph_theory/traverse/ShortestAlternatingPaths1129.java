package lmz.leetcode.graph_theory.traverse;

import lmz.my.leetcode.TransformUtil;

import java.util.*;

public class ShortestAlternatingPaths1129 {
    /**
     * BFS
     */
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        //2 <= n <= 1000
        //边的集合转换为邻接表
        ArrayList<Integer>[] redList =new ArrayList[n];
        ArrayList<Integer>[] blueList =new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            redList[i] = new ArrayList<Integer>();
            blueList[i] = new ArrayList<Integer>();
        }
        for (int[] edge : redEdges){
            redList[edge[0]].add(edge[1]);
        }
        for (int[] edge : blueEdges){
            blueList[edge[0]].add(edge[1]);
        }

        boolean[] redVisited = new boolean[n];
        boolean[] blueVisited = new boolean[n];
        //BFS,<v,color,len>
        Queue<int[]> queue = new LinkedList<>();
        //0-red,1-blue
        //初始0可以走红色和蓝色两条路
        queue.add(new int[]{0, 0, 0});
        queue.add(new int[]{0, 1, 0});
        //注意，因为有红蓝两种选择，则应该有两种标记
        redVisited[0] = true; //标记访问
        blueVisited[0] = true; //标记访问
        int[] res = new int[n];
        Arrays.fill(res, -1);
        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            int v = x[0], color = x[1], len = x[2];
            if (res[v] == -1){ //第一次访问为最小距离
                res[v] = len;
            }
            if (color == 0) { //red
                for (int w : blueList[v]) {
                    if ( !blueVisited[w]) {
                        blueVisited[w] = true; //标记访问
                        queue.add(new int[]{w, 1, len + 1});
                    }
                }
            } else {
                for (int w : redList[v]) {
                    if ( !redVisited[w]) {
                        redVisited[w] = true; //标记访问
                        queue.add(new int[]{w, 0, len + 1});
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestAlternatingPaths1129 shortestAlternatingPaths1129 = new ShortestAlternatingPaths1129();

        System.out.println(Arrays.toString(shortestAlternatingPaths1129.shortestAlternatingPaths(3,
                TransformUtil.toIntMatrix("[[0,1],[1,2]]"), TransformUtil.toIntMatrix("[]"))));
        System.out.println(Arrays.equals(shortestAlternatingPaths1129.shortestAlternatingPaths(3,
                TransformUtil.toIntMatrix("[[0,1],[1,2]]"), TransformUtil.toIntMatrix("[]")), TransformUtil.toIntArray("[0,1,-1]")));

        System.out.println(Arrays.toString(shortestAlternatingPaths1129.shortestAlternatingPaths(5,
                TransformUtil.toIntMatrix("[[0,1],[1,2],[2,3],[3,4]]"), TransformUtil.toIntMatrix("[[1,2],[2,3],[3,1]]"))));
        System.out.println(Arrays.equals(shortestAlternatingPaths1129.shortestAlternatingPaths(5,
                TransformUtil.toIntMatrix("[[0,1],[1,2],[2,3],[3,4]]"), TransformUtil.toIntMatrix("[[1,2],[2,3],[3,1]]")), TransformUtil.toIntArray("[0,1,2,3,7]")));
    }
}

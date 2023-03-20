package lmz.leetcode.contest.old.c312;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfGoodPaths {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        //2 <= n <= 10^5
        //边的集合转换为邻接表
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (var edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }


        HashSet<String> set = new HashSet<>();
        HashSet<Integer> intSet = new HashSet<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(!intSet.contains(vals[i])){
                intSet.add(vals[i]);
            }else{
                continue;
            }
            //BFS
            boolean[] visited = new boolean[n];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{i, i});
            visited[i] = true; //标记访问
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                int v = pos[0];
                int start = pos[1];
                for (int w : adjList[v]) {
                    if (!visited[w] && vals[start] >= vals[w]) {
                        visited[w] = true; //标记访问
                        queue.add(new int[]{w, start});
                        if (vals[start] == vals[w]) {
                            int min, max;
                            if (start < w) {
                                max = w;
                                min = start;
                            } else {
                                max = start;
                                min = w;
                            }
                            String s = min + "-" + max;
                            if (!set.contains(s)) {
                                set.add(s);
                                res++;
                            }
                        }
                    }
                }
            }
        }
        return res + n;
    }

    public static void main(String[] args) {
        NumberOfGoodPaths numberOfGoodPaths = new NumberOfGoodPaths();
        System.out.println(numberOfGoodPaths.numberOfGoodPaths(
                TransformUtil.toIntArray("[1,3,2,1,3]"), TransformUtil.toIntMatrix("[[0,1],[0,2],[2,3],[2,4]]")));
    }
}

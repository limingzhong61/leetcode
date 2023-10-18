package com.lmz.algorithm_practice.graph.traverse.bfs;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class CanReach1306 {
    /**
     * bfs
     */
    public boolean canReach(int[] arr, int start) {
        //1 <= arr.length <= 5 * 10^4
        int n = arr.length;
        //BFS
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true; //标记访问
        if (arr[start] == 0) {
            return true;
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            int w = v + arr[v];
            if (w >= 0 && w < n && !visited[w]) {
                if (arr[w] == 0) {
                    return true;
                }
                visited[w] = true; //标记访问
                queue.add(w);
            }
            w = v - arr[v];
            if (w >= 0 && w < n && !visited[w]) {
                if (arr[w] == 0) {
                    return true;
                }
                visited[w] = true; //标记访问
                queue.add(w);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanReach1306 canReach = new CanReach1306();

        testCase(canReach, "[4,2,3,0,3,1,2]\n", 5, true);

        testCase(canReach, "[4,2,3,0,3,1,2]", 0, true);

        testCase(canReach, " [3,0,2,1,2]", 2, false);
        testCase(canReach, " [0]", 0, true);
    }

    private static void testCase(CanReach1306 canReach, String s, int i, boolean b) {
        System.out.println(canReach.canReach(TransformUtil.toIntArray(s), i));
        System.out.println(String.valueOf(canReach.canReach(TransformUtil.
                toIntArray(s), i) == b).toUpperCase(Locale.ROOT));
    }
}

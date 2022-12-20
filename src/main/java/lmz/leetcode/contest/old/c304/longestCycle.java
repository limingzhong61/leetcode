package lmz.leetcode.contest.old.c304;

import java.util.LinkedList;
import java.util.Queue;

public class longestCycle {
    public int longestCycle(int[] edges) {
        //n == edges.length
        // 2 <= n <= 105
        int n = edges.length;
        //标记访问，
        int[] visited1 = new int[n];
        int[] len1 = new int[n];
        int maxLen = -1;
        int markValue = 1;
        for(int i = 0; i < n; i++){
            if(visited1[i] == 0){
                maxLen = Math.max(maxLen,bfs(edges,visited1,len1,i,markValue++));
            }
        }
        return maxLen;
    }


    private int bfs(int[] edges, int[] visited, int[] len1, int node1,int markValue) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{node1, 0});
        visited[node1] = markValue;
        len1[node1] = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int node = poll[0];
            int curLen = poll[1];
            if (edges[node] == -1) { //没有出边
                return -1;
            }
            if(visited[edges[node]] == markValue){ //|| 已经访问过并且是当前被访问过得。
                int start = edges[node];

                return curLen - len1[start] + 1;
            }
            if (edges[node] != 0) { //已经被访问过
                return -1;
            }
            node = edges[node];
            visited[node] = markValue;
            len1[node] = curLen + 1;
            queue.add(new int[]{node, curLen + 1});
        }
        return -1;
    }
}

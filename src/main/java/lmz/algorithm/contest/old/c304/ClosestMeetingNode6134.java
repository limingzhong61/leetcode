package lmz.algorithm.contest.old.c304;

import java.util.LinkedList;
import java.util.Queue;

public class ClosestMeetingNode6134 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        //n == edges.length
        // 2 <= n <= 105
        int n = edges.length;
        //标记访问，
        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];
        int[] len1 = new int[n];
        int[] len2 = new int[n];
        bfs(edges, visited1, len1, node1);
        bfs(edges,visited2,len2,node2);
        int min = Integer.MAX_VALUE;
        int resNode = -1;
        for(int i = 0;  i < n; i++){
            if(visited1[i] && visited2[i]){
                int maxLen = Math.max(len1[i], len2[i]);
                if(maxLen < min){
                    resNode = i;
                    min = maxLen;
                }
            }
        }
        return resNode;
    }

    private void bfs(int[] edges, boolean[] visited, int[] len1, int node1) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{node1, 0});
        visited[node1] = true;
        len1[node1] = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int node = poll[0];
            int curLen = poll[1];
            if (edges[node1] == -1 || visited[edges[node1]]) { //没有出边 || 已经访问过
                return;
            }
            node1 = edges[node1];
            visited[node1] = true;
            len1[node1] = curLen + 1;
            queue.add(new int[]{node1, curLen + 1});
        }

    }

    public static void main(String[] args) {
        //new
    }
}

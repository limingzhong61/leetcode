package com.lmz.algorithm_practice.other.medium;

public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] graph = new boolean[n][n];
        //for(int i = 0; i < n; i++){
        //    graph[i] = new ArrayList<>();
        //}
        int[] degrees = new int[n];
        for (var road : roads) {
            graph[road[0]][road[1]] = true;
            graph[road[1]][road[0]] = true;
            degrees[road[0]]++;
            degrees[road[1]]++;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = degrees[i] + degrees[j];
                if (graph[i][j]) {
                    sum--;
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}

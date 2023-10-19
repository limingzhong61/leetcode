package com.lmz.leetcode.practice.graph.character;

public class FindJudge997 {
    /**
     * judge：出度=0，入度=n-1
     */
    public int findJudge(int n, int[][] trust) {
        //[1-n]
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        for (int[] item : trust) {
            outDegree[item[0]]++;
            inDegree[item[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}

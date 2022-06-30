package codeofli.leetcode.graph_theory.character;

import codeofli.my.leetcode.TransformUtil;

import java.util.*;

public class MaximalNetworkRank1615 {
    /**
     * 统计每个点的入度或出度，最大和即为答案
     */
    public int maximalNetworkRank(int n, int[][] roads) {
        //2 <= n <= 100
        int[] outDegree = new int[n];
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }
        for(var item : roads){
            outDegree[item[0]]++;
            outDegree[item[1]]++;
            adjList[item[0]].add(item[1]);
            adjList[item[1]].add(item[0]);
        }
        int res = 0;
        for(int i = n-1; i >= 1;i--){
            int out1 = outDegree[i];
            for(int j = i-1; j >= 0;j--){
                int out2 = outDegree[j];
                int cnt = out1+out2;
                //两点相连则减1
                if (adjList[i].contains(j)) {
                    cnt--;
                }
                if(res < cnt){
                    res = cnt;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximalNetworkRank1615 maximalNetworkRank1615 = new MaximalNetworkRank1615();

        testCase(maximalNetworkRank1615, 4, "[[0,1],[0,3],[1,2],[1,3]]",4);

        testCase(maximalNetworkRank1615, 5, "[[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]",5);
        testCase(maximalNetworkRank1615, 8, "[[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]",5);
    }

    private static void testCase(MaximalNetworkRank1615 maximalNetworkRank1615, int i, String s,int res) {
        System.out.println(maximalNetworkRank1615.maximalNetworkRank(i,
                TransformUtil.toIntMatrix(s)));
        System.out.println(maximalNetworkRank1615.maximalNetworkRank(i,
                TransformUtil.toIntMatrix(s)) == res);
    }
}

package com.lmz.algorithm_practice.other.medium.old;

/**
 * @author: limingzhong
 * @create: 2023-01-24 10:28
 */
public class CountPoints1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length,idx = 0;
        int[] res = new int[n];
        for(int[] query : queries){
            int x = query[0], y = query[1],r = query[2],cnt = 0;
            for(int[] point : points){
                if(r * r >= (x - point[0]) * (x - point[0]) + (y - point[1]) * (y - point[1])){
                    cnt++;
                }
            }
            res[idx++] = cnt;
        }
        return  res;
    }
}

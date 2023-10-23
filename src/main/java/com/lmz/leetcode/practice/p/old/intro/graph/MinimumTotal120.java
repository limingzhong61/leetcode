package com.lmz.leetcode.practice.p.old.intro.graph;

import java.util.List;

public class MinimumTotal120 {
    /**
     * 自顶向下==自底向上
     * f[i,j]表示自底向上到达f[i,j]的最小值
     * */
    public int minimumTotal(List<List<Integer>> triangle) {
        //1 <= triangle.length <= 200
        //triangle[0].length == 1
        //triangle[i].length == triangle[i - 1].length + 1
        int m = triangle.size();
        int[] f = new int[m];
        for(int i = 0; i < m; i++){
            f[i] = triangle.get(m-1).get(i);
        }
        for(int i = m-1; i >= 1 ;i--){
            for(int j = 0; j < i;j++){ //上一层，少一个数，故[0,i)
                //f[i-1][j] = Math.min(f[i][j],f[i][j+1])
                f[j] = Math.min(f[j],f[j+1]) + triangle.get(i).get(j);
            }
        }
        return  f[0];
    }
}

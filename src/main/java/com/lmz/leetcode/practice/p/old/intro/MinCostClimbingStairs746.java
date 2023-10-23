package com.lmz.leetcode.practice.p.old.intro;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class MinCostClimbingStairs746 {
    /**
     * f[n] = min{f[i]+cost[n-i-1]}, n-2<= i <= n-1; //因爲cast[i]移动i+1
     * f[0] = 0,f[1] = 0;
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] f = new int[n + 1];
        //f[0] = 0,f[1] = 0;
        for (int i = 2; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = i-2; j < i; j++) {
                f[i] = Math.min(f[i], f[j] + cost[j]);
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs746 minCostClimbingStairs746 = new MinCostClimbingStairs746();
        //System.out.println(minCostClimbingStairs746.minCostClimbingStairs(TransformUtil.toIntArray("[10,15,20]")));
        System.out.println(minCostClimbingStairs746.minCostClimbingStairs(TransformUtil.toIntArray(" [1,100,1,1,1,100,1,1,100,1]")));
    }
}

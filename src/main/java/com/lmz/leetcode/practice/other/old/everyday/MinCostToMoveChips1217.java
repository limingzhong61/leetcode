package com.lmz.leetcode.practice.other.old.everyday;

public class MinCostToMoveChips1217 {
    /**
     * 因为移动两步没有代价，则将所有归并到cnt[0,1]中即可
     * ans = min(cnt[0],cnt[1])
     */
    public int minCostToMoveChips(int[] position) {
        int[] cnt = new int[2];
        for(int item : position){
            cnt[item%2]++;
        }
        return Math.min(cnt[0],cnt[1]);
    }
}

package com.lmz.algorithm.contest.old.c85;

public class MinimumRecolors6156 {
    public int minimumRecolors(String blocks, int k) {
        char[] cs = blocks.toCharArray();
        int n = cs.length;
        int cntK = 0;
        for(int i = 0; i < k; i++){
            if(cs[i] == 'B'){
                cntK++;
            }
        }
        int min = k - cntK;
        for(int i = k ; i < n; i++){
            if(cs[i] == 'B'){
                cntK++;
            }
            if(cs[i-k] == 'B'){
                cntK--;
            }
            min = Math.min(min,k-cntK);
        }
        return min;
    }
}

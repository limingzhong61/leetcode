package com.lmz.leetcode.practice.p.easy.old;

public class ChalkReplacer1894 {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int x : chalk){
            sum += x;
        }
        k %= sum;
        for(int i = 0; i < chalk.length; i++){
            k -= chalk[i];
            if(k < 0){
                return i;
            }
        }
        return -1;
    }
}

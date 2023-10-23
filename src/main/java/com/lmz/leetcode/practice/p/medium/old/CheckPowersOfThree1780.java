package com.lmz.leetcode.practice.p.medium.old;

public class CheckPowersOfThree1780 {
    public boolean checkPowersOfThree(int n) {
        var f = new int[20];
        f[0] =1;
        for(int i = 1; i < 20; i++){
            f[i] = f[i-1] * 3;
        }
        for(int i = 20; i >= 0; i--){
            if(f[i] < n){
                n -= f[i];
                System.out.printf("%d\n",n);
            }
        }
        return n == 0;
    }
}

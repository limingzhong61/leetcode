package com.lmz.leetcode.practice.find.binary_search;

import java.util.stream.IntStream;

public class MinEatingSpeedII073 {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1,high = IntStream.of(piles).max().getAsInt();
        // f,f,T,T
        while(low <= high){
            int mid = low + (high - low)/ 2;
            if(check(piles,h,mid) ){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean check(int[] piles, int h, int x) {
        int total = 0;
        for(var p : piles){
            int d = p / x;
            total += d;
            if(d * x < p){
                total++;
            }
            if(total > h){
                return false;
            }
        }
        return true;
    }
}

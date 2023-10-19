package com.lmz.leetcode.practice.contest.c326;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-01-01 10:48
 */
public class ClosestPrimes {
    public int[] closestPrimes(int left, int right) {
        int n = right + 1;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] =false;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) { //i是素数
                if ((long) i * i < n) { //防止i*i越界,i*i之前的都被标记了：2*i,3*i...
                    for (int j = i * i; j < n; j += i) { //i的倍数不是素数。
                        isPrime[j] = false;
                    }
                }
            }
        }
        int[] res = new int[2];
        boolean find = false;
        int lastVal = 0,minDist = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                if(lastVal != 0){ // 有两个值；
                    if(i - lastVal < minDist){
                        minDist = i - lastVal;
                        res = new int[]{lastVal,i};
                        find = true;
                    }
                }
                lastVal = i;
            }
        }
        if(find){
            return res;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        ClosestPrimes closestPrimes = new ClosestPrimes();
        System.out.println(Arrays.toString(closestPrimes.closestPrimes(19, 31)));
    }
}

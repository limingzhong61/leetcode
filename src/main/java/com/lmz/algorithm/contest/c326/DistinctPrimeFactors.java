package com.lmz.algorithm.contest.c326;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: limingzhong
 * @create: 2023-01-01 10:36
 */
public class DistinctPrimeFactors {
    public int distinctPrimeFactors(int[] nums) {
        //if (n < 2) {//0，1本身就不是素数
        //    return 0;
        //}
        int n = 1001;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) { //i是素数
                if ((long) i * i < n) { //防止i*i越界,i*i之前的都被标记了：2*i,3*i...
                    for (int j = i * i; j < n; j += i) { //i的倍数不是素数。
                        isPrime[j] = false;
                    }
                }
            }
        }
        int cnt = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            for (int i = 2; i <= x; i++) {
                if (isPrime[i]) {
                    System.out.printf("prime=%d", i);
                    while (x > 1 && x % i == 0) {
                        System.out.printf("x=%d", x);
                        if(!set.contains(i)){
                            cnt++;
                            set.add(i);
                        }
                        x /= i;
                    }
                }
            }
        }
        return cnt;
    }


}

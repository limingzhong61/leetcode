package com.lmz.algorithm.p.other;

/**
 * @author: limingzhong
 * @create: 2023-09-20 9:14
 */
public class MinCountLCP06 {
    public int minCount(int[] coins) {
        int ans = 0;
        for(int x : coins){
            ans += x / 2;
            if(x % 2 != 0) ans++;
        }
        return ans;
    }
}

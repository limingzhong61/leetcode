package com.lmz.leetcode.practice.p.medium.old;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-02-04 9:44
 */
public class GetMaximumConsecutive1798 {
    /**
     * 贪心+脑筋急转弯：
     * 从小到大排序，如果 在i-1处能形成连续0到x的值，如果i的值-1 >= x，则能形成0到coins[i]+x的值，
     * 此时i能形成0-coins[i]+x;
     */
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int n = coins.length;
        int maxVal = 0;
        for(int i = 0; i < n; i++){
            if(coins[i] - 1 <= maxVal){
                maxVal = coins[i] + maxVal;
            }
        }
        return  maxVal;
    }
}

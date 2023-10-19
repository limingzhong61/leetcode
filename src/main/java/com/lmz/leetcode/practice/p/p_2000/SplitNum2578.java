package com.lmz.leetcode.practice.p.p_2000;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-10-09 10:24
 */
public class SplitNum2578 {
    public int splitNum(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        Arrays.sort(cs);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int idx1 = 0,idx2 = 1, n = cs.length;
        for(; idx1 < n || idx2 < n; idx1 += 2, idx2 += 2){
            if(idx1 < n) sb1.append(cs[idx1]);
            if(idx2 < n) sb2.append(cs[idx2]);
        }
        return Integer.valueOf(sb1.toString()) + Integer.valueOf(sb2.toString());
    }
}

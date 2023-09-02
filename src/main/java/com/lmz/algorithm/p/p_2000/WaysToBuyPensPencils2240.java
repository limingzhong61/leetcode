package com.lmz.algorithm.p.p_2000;

/**
 * @author: limingzhong
 * @create: 2023-09-01 8:51
 */
public class WaysToBuyPensPencils2240 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for (int i = 0; i * cost1 <= total; i++) {
            int remain = total - i * cost1;
            int d = remain / cost2;
            // 能整除？
            if (remain % cost2 == 0) {
                d++;
            }
            ans = ans + d;
        }
        return ans;
    }
}

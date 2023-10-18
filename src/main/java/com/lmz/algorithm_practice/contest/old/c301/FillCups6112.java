package com.lmz.algorithm_practice.contest.old.c301;

import java.util.Arrays;

public class FillCups6112 {
    /**
     * 模拟
     */
    public int fillCups(int[] amount) {
        int cnt = 0;
        Arrays.sort(amount);
        int sum = amount[0] + amount[1] + amount[2];
        while (sum > 0) {
            amount[2]--;
            if (amount[1] > 0)
                amount[1]--;
            cnt++;
            Arrays.sort(amount);
            sum = amount[0] + amount[1] + amount[2];
        }
        return cnt;
    }
}

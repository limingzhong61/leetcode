package com.lmz.leetcode.practice.other.easy.old;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2022-12-31 9:36
 */
public class MinMovesToSeat2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        int n = seats.length;
        for(int i = 0; i < n; i++){
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}

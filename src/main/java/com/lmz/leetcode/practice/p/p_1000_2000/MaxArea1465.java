package com.lmz.leetcode.practice.p.p_1000_2000;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-10-27 11:17
 */
public class MaxArea1465 {
    class Solution {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            Arrays.sort(horizontalCuts);
            Arrays.sort(verticalCuts);
            return (int) ((long) calMax(horizontalCuts, h) * calMax(verticalCuts, w) % 1000000007);
        }

        public int calMax(int[] arr, int boardr) {
            int res = 0, pre = 0;
            for (int i : arr) {
                res = Math.max(i - pre, res);
                pre = i;
            }
            return Math.max(res, boardr - pre);
        }
    }

}

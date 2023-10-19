package com.lmz.leetcode.practice.other.medium;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-03-30 9:28
 */
public class MaxWidthOfVerticalArea1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(a,b) -> a[0] -b[0]);
        int n = points.length;
        int max = 0;
        for(int i = 1; i < n; i++){
            max = Math.max(max,points[i][0] - points[i-1][0]);
        }
        return  max;
    }
}

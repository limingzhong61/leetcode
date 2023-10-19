package com.lmz.leetcode.practice.other.medium.old;

import java.util.Arrays;
import java.util.List;

public class FindMinDifferenceII035 {
    /**
     * 鸽巢原理：
     * 根据题意，一共有  24 × 60 = 1440 种不同的时间。由鸽巢原理可知，如果 timePoints 的长度超过 1440
     * 1440，那么必然会有两个相同的时间，此时可以直接返回 0。
     */
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) {
            return 0;
        }

        var times = new int[n];
        for (int i = 0; i < n; i++) {
            String[] split = timePoints.get(i).split(":");
            times[i] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
        Arrays.sort(times);
        int res = (times[0] - times[n - 1] + 60 * 24) % ( 60 * 24);
        for (int i = 1; i < n; i++) {
            res = Math.min(times[i] - times[i - 1], res);
        }

        return res;
    }

    public int findMinDifference1(List<String> timePoints) {
        int n = timePoints.size();
        var times = new int[n];
        for (int i = 0; i < n; i++) {
            String[] split = timePoints.get(i).split(":");
            times[i] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
        Arrays.sort(times);
        int res = (times[0] - times[n - 1] + 60 * 24) % ( 60 * 24);
        for (int i = 1; i < n; i++) {
            res = Math.min(times[i] - times[i - 1], res);
        }

        return res;
    }
}

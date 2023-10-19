package com.lmz.leetcode.practice.contest.c333;

import java.util.Arrays;
import java.util.HashMap;

public class MergeArrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (var x : nums1) {
            map.put(x[0], x[1]);
        }
        for (var x : nums2) {
            map.put(x[0], x[1] + map.getOrDefault(x[0], 0));
        }
        int[][] res = new int[map.size()][2];
        int idx = 0;
        for (var x : map.entrySet()) {
            res[idx][0] = x.getKey();
            res[idx++][1] = x.getValue();
        }
        Arrays.sort(res, (a, b) -> a[0] - a[1]);
        return  res;
    }
}

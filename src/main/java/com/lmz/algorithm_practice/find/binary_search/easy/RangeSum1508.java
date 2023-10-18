package com.lmz.algorithm_practice.find.binary_search.easy;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;

public class RangeSum1508 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        //    1 <= nums.length == n <= 10^3
        int[] sums = new int[n * (n + 1) / 2];
        //int[] prefixSum  = new int[n+1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = i; j < n; j++) {
                temp += nums[j];
                sums[idx++] = temp;
            }
        }
        int MOD = 1000000000 + 7;
        Arrays.sort(sums);
        int res = 0;
        for (int i = left -1; i <= right -1; i++) {
            res = (res + sums[i]) % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        RangeSum1508 rangeSum1508 = new RangeSum1508();
        System.out.println(rangeSum1508.rangeSum(TransformUtil.toIntArray("[1,2,3,4]"), 4, 1, 5));
    }
}

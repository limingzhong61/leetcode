package com.lmz.leetcode.practice.dp._0_1_bags_problem;

import java.util.stream.IntStream;

/**
 * @author: limingzhong
 * @create: 2023-06-28 22:31
 */
public class FindTargetSumWays494 {
    /**
     * +： p
     * -: sum - p
     * p-(s-p) = t
     * p = (s+t)/2
     * 0 <= nums[i] <= 1000
     * 0 <= sum(nums[i]) <= 1000
     */
    public int findTargetSumWays(int[] nums, int target) {
        target += IntStream.of(nums).sum();
        if(target < 0 || target % 2 == 1) return  0;
        target /= 2;

        int n = nums.length;
        int high = 1000;
        int[][] f = new int[n + 1][target+1];
        f[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = nums[i]; j <= target; j++) {
                f[i+1][j] = f[i][j] + f[i][j-nums[i]];
            }
        }
        return f[n][target];
    }
}

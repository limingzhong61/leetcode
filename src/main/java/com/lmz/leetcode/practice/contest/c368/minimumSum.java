package com.lmz.leetcode.practice.contest.c368;

/**
 * @author: limingzhong
 * @create: 2023-10-22 10:35
 */
public class minimumSum {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] < nums[j] && nums[j] > nums[i]) {
                        ans = Math.min(ans, nums[k] + nums[j] + nums[i]);
                    }
                }
            }
        }
        return ans ==Integer.MAX_VALUE ? -1 : ans;
    }
}

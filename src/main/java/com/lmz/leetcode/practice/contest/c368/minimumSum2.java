package com.lmz.leetcode.practice.contest.c368;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-10-22 10:35
 */
public class minimumSum2 {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] leftMins = new int[n];
        int[] rightMins = new int[n];
        Arrays.fill(leftMins, Integer.MIN_VALUE / 3);
        Arrays.fill(rightMins, Integer.MIN_VALUE / 3);

        leftMins[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMins[i] = Math.min(nums[i], leftMins[i - 1]);
        }

        rightMins[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMins[i] = Math.min(nums[i], rightMins[i + 1]);
        }

        for (int i = 1; i <= n - 2; i++) {
            if (leftMins[i - 1] < nums[i] && nums[i] > rightMins[i + 1])
                ans = Math.min(ans, leftMins[i - 1] + rightMins[i + 1] + nums[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        minimumSum2 minimumSum2 = new minimumSum2();
        System.out.println(minimumSum2.minimumSum(TransformUtil.toIntArray("[8,6,1,5,3]")));
    }
}

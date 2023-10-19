package com.lmz.leetcode.practice.math;

import java.util.Arrays;

public class MaxProduct1464 {
    public int maxProduct(int[] nums) {
        // 2 <= nums.length <= 500
        Arrays.sort(nums);
        int len = nums.length;
        //1 <= nums[i] <= 10^3，没有负数，则最大值肯定是后两个之积
        return (nums[len - 1] - 1) * (nums[len - 2] - 1);
    }
}

package com.lmz.util.solution_template.arrays;
/**
 * 前缀和
 */
public class ArraySum {
    int[] nums;
    // sums[i] = nums[0,i-1]
    int[] sums;

    public ArraySum(int[] nums) {
        this.sums = ArraysUtil.getPrefixSumArray(nums);
    }

    /**
     * 前缀和
     */
    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}

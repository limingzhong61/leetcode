package codeofli.leetcode.math;

import java.util.Arrays;

public class MaximumProduct628 {
    /**
     * 排序之后最大乘积就两种情况：1、如果全是正数就是最后三个数相乘
     * 2、如果有负数最大的乘机要么是最后三个数相乘，要么是两个最小的负数相乘再乘以最大的正数
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        //3 <= nums.length <= 104
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 2] * nums[n - 3] * nums[n - 1]);
    }

    /**
     * 排序后计算
     */
    public int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        //3 <= nums.length <= 104
        int n = nums.length;
        if (n == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        if (nums[n - 1] > 0) { //4个数最后一个为正数，则结果肯定>= 0
            int left = nums[0] * nums[1];
            int right = nums[n - 2] * nums[n - 3];
            return Math.max(left, right) * nums[n - 1]; //第三个数选一个最大的正数
        } else {
            return nums[n - 1] * nums[n - 2] * nums[n - 3]; //全为0或者负数，结果为最右侧相乘
        }
    }
}

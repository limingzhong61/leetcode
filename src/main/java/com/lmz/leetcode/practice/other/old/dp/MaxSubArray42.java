package com.lmz.leetcode.practice.other.old.dp;

public class MaxSubArray42 {
    /**
     * dp:
     * dp[i] : [0,i]最大连续子数组值（不一定以i结尾）
     * temp[i] : 以i结尾的[0,i]最大连续子数组值
     *
     * temp[i] = max(temp[i-1]+nums[i],nums[i])
     * dp[i] = max(temp[i],dp[i-1])
     * 可以用滚动数组节省空间
     * temp: temp
     * temp = max(temp+nums[i],nums[i])
     * maxSum = (temp,maxSum)
     *
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int temp = nums[0];
        for(int i = 1; i < n; i++){
            temp = Math.max(temp+nums[i],nums[i]);
            maxSum = Math.max(temp,maxSum);
        }
        return maxSum;
    }

    /**
     * dp:
     * dp[i] : [0,i]最大连续子数组值（不一定以i结尾）
     * temp[i] : 以i结尾的[0,i]最大连续子数组值
     *
     * temp[i] = max(temp[i-1]+nums[i],nums[i])
     * dp[i] = max(temp[i],dp[i-1])
     */
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] temp = new int[n];
        dp[0] = nums[0];
        temp[0] = nums[0];
        for(int i = 1; i < n; i++){
            temp[i] = Math.max(temp[i-1]+nums[i],nums[i]);
            dp[i] = Math.max(temp[i],dp[i-1]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        MaxSubArray42 maxSubArray42 = new MaxSubArray42();
        System.out.println(maxSubArray42.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray42.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6);

    }
}

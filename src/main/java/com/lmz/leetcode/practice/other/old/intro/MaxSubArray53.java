package com.lmz.leetcode.practice.other.old.intro;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class MaxSubArray53 {
    /**
     * dp
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = Math.max(0,nums[0]);
        for(int i =1 ;i < n; i++){
            f[i] = Math.max(f[i]+ nums[i],0);
        }
        return f[n-1];
    }

    class Solution{
        /**
         dp+滚动数组优化
         dp[i]表示nums[0,i]中以i结尾的最大子序列和值。
         只用到了i,i-1故用dp1,dp0表示
         */
        public int maxSubArray(int[] nums) {
            //1 <= nums.length <= 10^5
            int dp0 = nums[0],dp1;
            int maxSub = nums[0];
            for(int i = 1; i < nums.length; i++){
                dp1 = Math.max(0,dp0) + nums[i];
                maxSub = Math.max(maxSub,dp1);
                dp0 = dp1;
            }
            return maxSub;
        }
        public int maxSubArray2(int[] nums) {
            //1 <= nums.length <= 10^5

            int[] dp = new int[nums.length]; // 表示nums[0,i]中以i结尾的最大子序列和值。
            dp[0] = nums[0];
            int maxSub = nums[0];
            for(int i = 1; i < nums.length; i++){
                dp[i] = Math.max(nums[i],dp[i-1] + nums[i]);
                maxSub = Math.max(maxSub,dp[i]);
            }
            return maxSub;
        }
        /**
         * my:
         * 状态：sub[i]表示nums[0,i]中以i结尾的最大子序列和值。
         * sub[i] = max(nums[i],sub[i]+nums[i])
         因为需要取最大值
         * 设置maxSum,表示nums[0,i]中的最大子数组和
         * maxSum = max(maxSum,sub[i])
         * 可以省略数组
         */
        public int maxSubArray1(int[] nums) {
            int maxSum = nums[0];
            int sub = nums[0];
            for(int i = 1; i < nums.length; i++){
                sub = Math.max(nums[i],sub+nums[i]);
                maxSum = Math.max(maxSum,sub);
            }
            return  maxSum;
        }
    }

    public static void main(String[] args) {
        MaxSubArray53 maxSubArray53 = new MaxSubArray53();
        System.out.println(maxSubArray53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6);

        System.out.println(maxSubArray53.maxSubArray(TransformUtil.toIntArray("[-2,1]")));
        System.out.println(maxSubArray53.maxSubArray(TransformUtil.toIntArray("[-2,1]")) == 1);
    }
}

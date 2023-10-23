package com.lmz.leetcode.practice.p.easy.old;

public class MaxAscendingSum1800 {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int maxSum = sum;
        for(int i = 1; i < n; i++){
            if(nums[i -1] < nums[i]){
                sum += nums[i];
            }else{
                sum = nums[i]; // 重新记录
            }
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}

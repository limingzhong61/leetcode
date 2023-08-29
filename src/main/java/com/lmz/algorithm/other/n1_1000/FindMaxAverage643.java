package com.lmz.algorithm.other.n1_1000;

/**
 * @author: limingzhong
 * @create: 2023-08-05 15:27
 */
public class FindMaxAverage643 {
    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        int ans = sum;
        for(int i = k; i < n; i++){
            sum += -nums[i-k] + nums[i];
            ans =Math.max(ans,sum);
        }
        return ans * 1.0 / k;
    }
}

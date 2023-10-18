package com.lmz.algorithm_practice.p.p_1000_2000;

/**
 * @author: limingzhong
 * @create: 2023-08-08 10:57
 */
public class MaxAbsoluteSum1749 {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = min[0] = nums[0];
        int ans = nums[0];
        for(int i = 1;  i < n; i++){
            max[i] = Math.max(0,max[i-1]) + nums[i];
            min[i] = Math.min(0,min[i-1]) + min[i];
            ans = Math.max(ans,Math.max(max[i],-min[i]));
        }
        return ans;
    }
}

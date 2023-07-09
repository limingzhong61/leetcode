package com.lmz.algorithm.dp;

/**
 * @author: limingzhong
 * @create: 2023-03-31 10:03
 */
public class RobII089 {
    /**
     * dp
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = Math.max(nums[1],nums[0]);
        int max = f[1];
        for(int i = 2; i < n; i++){
            f[i] = Math.max(f[i-1],f[i-2] + nums[i]);
            // System.out.printf("%d\n",f[i]);
            max = Math.max(f[i],max);
        }
        return max;
    }
}




















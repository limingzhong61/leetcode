package com.lmz.leetcode.practice.p.easy.old;

/**
 * @author: limingzhong
 * @create: 2023-02-24 8:20
 */
public class MinimumOperations2357 {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        while(true){

            int min = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                if(nums[i] != 0){
                    min = Math.min(min,nums[i]);
                }
            }

            if(Integer.MAX_VALUE == min){
                break;
            }
            cnt++;
            boolean notZero = false;
            for(int i = 0; i < n; i++){
                if(nums[i] != 0){
                    nums[i] -= min;
                }

            }
        }
        return cnt;
    }
}








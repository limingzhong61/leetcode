package com.lmz.algorithm_practice.p.p_1000_2000;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-08-05 15:22
 */
public class MaxOperations1679 {
    /**
     双指针
     */
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for(int left = 0,right = nums.length - 1;left < right; ){
            int sum = nums[left] + nums[right];
            if(sum == k){
                ans++;
                left++;
                right--;
            }else if(sum > k){
                right--;
            }else{
                left++;
            }
        }
        return ans;
    }
}

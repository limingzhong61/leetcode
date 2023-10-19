package com.lmz.leetcode.practice.data_structure.array;

public class IsMonotonic896 {
    public boolean isMonotonic(int[] nums) {
        //1 <= nums.length <= 105
        int n = nums.length;
        //1 >, 0 = ,-1 <
        int stat = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i-1]){
                if(stat < 0){
                    return false;
                }
                stat = 1;
            }else if(nums[i] < nums[i-1]){
                if(stat > 0){
                    return false;
                }
                stat = -1;
            }
        }
        return true;
    }
}

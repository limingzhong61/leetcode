package com.lmz.algorithm.other.old.two_pointer;

import java.util.HashSet;
import java.util.Set;

public class TwoSum57 {
    /**
     * 对撞双指针
     */
    public int[] twoSum(int[] nums, int target) {
        //1 <= nums.length
        int left = 0,right = nums.length-1;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum < target){
                left++;
            }else  if(sum > target){
                right--;
            }else {
                return new int[]{nums[left],nums[right]};
            }
        }
        return null;
    }

    /**
     * hashset
     */
    public int[] twoSum1(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{num, target - num};
            }
            set.add(num);
        }
        return nums;
    }
}

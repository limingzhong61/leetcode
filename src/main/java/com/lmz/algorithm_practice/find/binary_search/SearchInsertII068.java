package com.lmz.algorithm_practice.find.binary_search;

public class SearchInsertII068 {
    /**
     *  <,<,<= ,....
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[right] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return  right - 1;
    }
}

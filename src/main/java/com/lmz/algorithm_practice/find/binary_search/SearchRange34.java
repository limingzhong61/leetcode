package com.lmz.algorithm_practice.find.binary_search;


import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;

public class SearchRange34 {
    /**
     * 23.5.28
     * 二分查找，定循环不变量，红蓝分解法
     */
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return  new int[]{-1,-1};
        int start = low_bound(nums,target);
        if(start >= nums.length ||nums[start] != target){ //不存在start
            return  new int[]{-1,-1};
        }
        int end = low_bound(nums,target+ 1) - 1;
        return new int[]{start,end};
    }

    /**
     * L,R 找到>= target的左边界， 定义 L及左边< target,R及右边>=target;则L为答案
     * ——>终止条件 L==R——> 闭区间[0,len-1]
     * @param nums
     * @param target
     * @return
     */
    public  int low_bound(int[] nums,int target){
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return left;
    }


    /**
     * 二分查找，然后左右寻找边界
     */
    public int[] searchRange2(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index >= 0 && nums[index] == target) {
            int left = index, right = index;
            while (left >= 1 && nums[left - 1] == target) {
                left--;
            }
            while (right + 1 < nums.length && nums[right + 1] == target) {
                right++;
            }
            return new int[]{left,right};
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        SearchRange34 searchRange34 = new SearchRange34();
        System.out.println(searchRange34.searchRange(TransformUtil.toIntArray("[2,2]"), 3));
    }
}

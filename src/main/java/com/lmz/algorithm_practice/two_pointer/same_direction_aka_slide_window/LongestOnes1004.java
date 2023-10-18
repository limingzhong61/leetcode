package com.lmz.algorithm_practice.two_pointer.same_direction_aka_slide_window;

/**
 * @author: limingzhong
 * @create: 2023-04-23 12:05
 */
public class LongestOnes1004 {
    class Solution {
        /**
         双指针: 同向双指针，滑动窗口
         right 主动右移,left被动移动
         */
        public int longestOnes(int[] nums, int k) {
            int cnt = 0,ans = 0;
            //right 主动右移,left被动移动
            // 统计[left,right)区间内0的个数
            for(int left = 0,right = 0; right < nums.length; right++){
                if(nums[right] == 0) cnt++;
                while(cnt > k){
                    if(nums[left] == 0) cnt--;
                    left++;
                }
                ans =Math.max(ans,right - left + 1);
            }
            return ans;
        }
    }
}

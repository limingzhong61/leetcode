package com.lmz.algorithm_practice.p.p_1000_2000;

/**
 * @author: limingzhong
 * @create: 2023-08-06 11:04
 */
public class LongestSubarray1493 {
    /**
     * 双指针
     */
    public int longestSubarray(int[] nums) {
        int cnt = 0,ans = 0;
        // 统计区间[left,right) 内非一的个数，其中非1最多为1个
        for(int left = 0,right = 0; right < nums.length; right++){
            if(nums[right] != 1) cnt++;
            while(cnt > 1){
                if(nums[left] != 1) cnt--;
                left++;
            }
            ans = Math.max(ans,right - left);
        }
        return ans;
    }
}

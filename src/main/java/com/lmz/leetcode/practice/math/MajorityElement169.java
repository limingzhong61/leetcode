package com.lmz.leetcode.practice.math;

public class MajorityElement169 {
    /**
     * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * x,cnt记录
     */
    public int majorityElement(int[] nums) {
        int x = 0,cnt = 0;
        for(int num : nums){
            if(cnt == 0){
                x = num;
                cnt++;
            }else{
                if(x != num){
                    cnt--;
                }else{
                    cnt++;
                }
            }
        }
        return x;
    }
}

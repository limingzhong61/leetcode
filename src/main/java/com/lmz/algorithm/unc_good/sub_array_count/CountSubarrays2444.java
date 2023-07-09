package com.lmz.algorithm.unc_good.sub_array_count;

import com.lmz.my.leetcode.TransformUtil;

public class CountSubarrays2444 {
    /**
     * 对于每一个右端点都计算一共有多少合法的解
     */
    public long countSubarrays(int[] nums, int minK, int maxK) {
        //last 初始为-1
        int minI = -1,maxI = -1,last = -1;
        int n = nums.length;
        long res = 0;
        for(int i = 0; i < n; i++){
            if (nums[i] < minK || nums[i] > maxK) { // 记录上一次不合法的位置
                last = i;
            }
            if(minK == nums[i]){
                minI = i;
            }
            if(maxK == nums[i]){
                maxI = i;
            }
            if(minI > last && maxI > last){ //maxK,minK 都在 [last,i]中出现过一次
                res += Math.min(minI,maxI) - last;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        CountSubarrays2444 countSubarrays = new CountSubarrays2444();
        System.out.println(countSubarrays.countSubarrays(TransformUtil.toIntArray("[1,3,5,2,7,5]"), 1, 5));
        System.out.println(countSubarrays.countSubarrays(TransformUtil.toIntArray("[1,3,5,2,7,5]"), 1, 5) == 2);
        System.out.println(countSubarrays.countSubarrays(TransformUtil.toIntArray("[1,1,1,1]"), 1, 1));
        System.out.println(countSubarrays.countSubarrays(TransformUtil.toIntArray("[1,1,1,1]"), 1, 1) == 10);
    }
}

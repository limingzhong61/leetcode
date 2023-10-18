package com.lmz.algorithm_practice.contest.old.c84;

public class MinimumReplacement6144 {
    /**
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 109
     * 将数组变成元素按 非递减 顺序排列的数组
     */
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long pre = nums[n - 1];
        long cnt = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > pre){
                long k = (nums[i]-1) / pre;
                cnt+= k;
                pre = nums[i] / (k + 1);
            }else{
                pre = nums[i];
            }
        }
        return  cnt;
    }
}

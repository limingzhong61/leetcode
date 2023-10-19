package com.lmz.leetcode.practice.unc_good;

public class MinSubArrayLenII008 {
    /**
     * 前缀和+二分查找
     */
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int minLen = len + 1;
        for (int i = 0; i < len; i++) {
            int f = target + sum[i];
            //找到大于等于f的最小值
            int low = i + 1, high = len;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (f <= sum[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (low <= len) { //有找到一个数
                minLen = Math.min(minLen, low - i);
                // System.out.println(low);
                // System.out.println(i);
                // System.out.println(minLen);
                // System.out.println();
            }
        }
        return minLen != len + 1 ? minLen : 0;
    }
}

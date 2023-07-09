package com.lmz.algorithm.find.binary_search.not_unusual;

import com.lmz.my.leetcode.TransformUtil;

public class MinimumSize1760 {
    /**
     * 二分查找：
     * 在上下界内找到符合条件的最大值（左边界）
     */
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1, high = 1000000000;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(nums, maxOperations, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean check(int[] nums, int maxOperations, int x) {
        for (int i = 0; i < nums.length; i++) {
            int operateCnt = nums[i] / x;
            if (nums[i] % x == 0) {
                operateCnt--;
            }
            maxOperations -= operateCnt;
            if (maxOperations < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumSize1760 minimumSize1760 = new MinimumSize1760();
        System.out.println(minimumSize1760.minimumSize(TransformUtil.toIntArray("[9]"), 2));
    }
}

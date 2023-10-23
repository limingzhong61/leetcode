package com.lmz.leetcode.practice.p.medium.old;

/**
 * @author: codeofli
 * @create: 2022-11-24 10:53
 */
public class NumSubarrayBoundedMax795 {
    /**
     * 枚举右端点，（右端点固定）计算左端点数。
     * 生成的测试用例保证结果符合 32-bit 整数范围。
     */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int i0 = -1, i1 = -1, res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > right) {
                i0 = i;
            }
            if (nums[i] >= left && nums[i] <= right){
                i1 = i;
            }
            if(i1 > i0){
                res += i1 - i0;
            }
        }
        return res;
    }

    /**
     * 枚举右端点，（右端点固定）计算左端点数。
     * 生成的测试用例保证结果符合 32-bit 整数范围。
     */
    public int numSubarrayBoundedMax1(int[] nums, int left, int right) {
        int n = nums.length;
        int i0 = -1, i1 = -1, res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > right) i0 = i;
            if (nums[i] >= left) i1 = i;
            res += i1 - i0;
        }
        return res;
    }
}

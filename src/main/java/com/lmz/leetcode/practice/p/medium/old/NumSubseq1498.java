package com.lmz.leetcode.practice.p.medium.old;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;

public class NumSubseq1498 {
    /**
     * 二分查找
     * 注意： 2^n可能溢出
     */
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        final int  MOD = 1000000007;
        int[] f = new int[n + 1];
        f[0] = 1;
        for(int i = 1; i <= n; i++){
            f[i] = (f[i - 1] * 2) % MOD;
        }
        for (int i = 0; i < n; i++) {
            int idx = smallerNumberIndexByBSWithRangeCheck(nums, target - nums[i], i);
            if (idx >= i) { //有可能比数组中所有数字都小
                int len = idx - i;
                sum = (sum + f[len]) % MOD;
            }
        }
        return sum;
    }

    /**
     * 二分查找<= x的最大值下标，。
     * T, F,左边界
     */
    private int smallerNumberIndexByBSWithRangeCheck(int[] arr, int key, int fromIndex) {
        int low = fromIndex, high = arr.length - 1;
        int pos = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else { //此时 <= key
                pos = mid;
                low = mid + 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        NumSubseq1498 numSubseq1498 = new NumSubseq1498();
        System.out.println(numSubseq1498.numSubseq(TransformUtil.toIntArray(
                "[14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11," +
                        "10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14]\n"), 22));
    }
}

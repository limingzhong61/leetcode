package com.lmz.leetcode.practice.other.old.hard;

public class MinSwap801 {
    /**
     * dp:
     * 用f[i][0]表示[i]位置没有交换的使得[0,i]递增的最小交换次数
     * 用f[i][1]表示[i]位置交换后的使得[0,i]递增的最小交换次数
     */
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] f = new int[n][2];
        f[0][0] = 0;
        f[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums2[i] > nums2[i - 1] && nums1[i - 1] > nums1[i - 1]) { //本身有序
                if (nums2[i] > nums1[i - 1] && nums1[i] > nums2[i - 1]) { //交换有序
                    f[i][0] = Math.min(f[i - 1][0], f[i - 1][1]);
                    f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + 1;
                } else {
                    f[i][0] = f[i - 1][0];
                    f[i][1] = f[i - 1][1] + 1;
                }
            } else if (nums2[i] > nums1[i - 1] && nums1[i] > nums2[i - 1]) { //交换有序
                f[i][0] = f[i - 1][0];
                f[i][1] = f[i - 1][0] + 1;
            }
        }
        return Math.min(f[n - 1][0], f[n - 1][1]);
    }

}

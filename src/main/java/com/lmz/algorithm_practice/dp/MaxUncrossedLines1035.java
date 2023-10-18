package com.lmz.algorithm_practice.dp;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class MaxUncrossedLines1035 {
    /**
     * f[i,j]表示nums1[0,i]与nums2[0,j]的最大数目
     * f[i][j] = max(f[i-1][j],f[i][j-1],f[i-1][j-1] + 1) if nums1[i] == nums2[j]
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[][] f = new int[len1][len2];
        f[0][0] = nums1[0] == nums2[0] ? 1 : 0;
        for (int i = 1; i < len2; i++) {
            if (nums1[0] == nums2[i]) {
                f[0][i] = 1;
            } else {
                f[0][i] = f[0][i - 1];
            }
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (nums1[i] == nums2[j]) {
                    int before = j >= 1 ? f[i - 1][j - 1] : 0;
                    f[i][j] = Math.max(before + 1, f[i][j]);
                } else {
                    int t1 = j >= 1 ? f[i][j-1] : 0;
                    f[i][j] = Math.max(t1, f[i - 1][j]);
                }
            }
        }
        return f[len1 - 1][len2 - 1];
    }

    public static void main(String[] args) {
        MaxUncrossedLines1035 maxUncrossedLines1035 = new MaxUncrossedLines1035();
        testCase(maxUncrossedLines1035, "[1,4,2]", "[1,2,4]", 2);
        testCase(maxUncrossedLines1035, "[2,5,1,2,5]", "[10,5,2,1,5,2]", 3);
        testCase(maxUncrossedLines1035, "[3,3]", "[3]", 1);
    }

    private static void testCase(MaxUncrossedLines1035 maxUncrossedLines1035, String original, String original1, int x) {
        System.out.println(maxUncrossedLines1035.maxUncrossedLines(
                TransformUtil.toIntArray(original), TransformUtil.toIntArray(original1)));
        System.out.println(maxUncrossedLines1035.maxUncrossedLines(
                TransformUtil.toIntArray(original), TransformUtil.toIntArray(original1)) == x);
    }
}

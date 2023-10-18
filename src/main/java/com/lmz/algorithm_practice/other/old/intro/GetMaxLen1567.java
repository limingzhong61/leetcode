package com.lmz.algorithm_practice.other.old.intro;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class GetMaxLen1567 {
    /**
     * 因为有符号存在，则可以记录两个状态
     * f1[i]表示以i结尾的负值最长
     * f2[i]表示以i结尾的正值最长
     */
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] f1 = new int[n];
        int[] f2 = new int[n];
        if (nums[0] > 0) {
            f1[0] = 1;
        } else if (nums[0] < 0) {
            f2[0] = 1;
        }
        int maxLen = Math.max(f1[0], 0);
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                f1[i] = f2[i] = 0;
            } else if (nums[i] > 0) {
                f1[i] = f1[i - 1] + 1;
                f2[i] = f2[i - 1] > 0 ? f2[i - 1] + 1 : 0;
            } else { //nums[0] < 0
                f1[i] = f2[i - 1] > 0 ? f2[i - 1] + 1 : 0;
                f2[i] = Math.max(f1[i - 1] + 1, 1);

            }
            maxLen = Math.max(maxLen, f1[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        GetMaxLen1567 getMaxLen1567 = new GetMaxLen1567();
        testCase(getMaxLen1567, "[1,-2,-3,4]", 4);
        testCase(getMaxLen1567, "[0,1,-2,-3,-4]", 3);
        testCase(getMaxLen1567, "[-1,-2,-3,0,1]", 2);
        testCase(getMaxLen1567, "[1,2,3,5,-6,4,0,10]", 4);
        testCase(getMaxLen1567, "[0,9,-11,-11,-10,2]", 3);
        testCase(getMaxLen1567, "[-1,2]", 1);
    }

    private static void testCase(GetMaxLen1567 getMaxLen1567, String s, int i) {
        System.out.println(getMaxLen1567.getMaxLen(TransformUtil.toIntArray(s)));
        System.out.println(getMaxLen1567.getMaxLen(TransformUtil.toIntArray(s)) == i);
    }
}

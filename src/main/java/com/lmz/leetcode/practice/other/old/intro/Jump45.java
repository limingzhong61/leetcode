package com.lmz.leetcode.practice.other.old.intro;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;

public class Jump45 {
    /**
     * f[i] 表示需要的最少跳数
     * f[i] = min{f[i],j+nums[j]},j+nums[j]==i,
     * 题目条件：
     * 假设你总是可以到达数组的最后一个位置。
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= nums[i] && j + i < n; j++) {
                f[j + i] = Math.min(f[j + i], f[i] + 1);
            }
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        Jump45 jump45 = new Jump45();
        System.out.println(jump45.jump(TransformUtil.toIntArray("[2,3,1,1,4]")));
    }
}

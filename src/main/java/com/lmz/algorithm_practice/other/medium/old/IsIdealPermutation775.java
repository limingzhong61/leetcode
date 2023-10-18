package com.lmz.algorithm_practice.other.medium.old;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;

/**
 * @author: codeofli
 * @create: 2022-11-16 9:44
 */
public class IsIdealPermutation775 {
    /**
     * 只要有一个nums[i] > nums[j]且 j != i+1则，全局比多于局部的个数
     * 1 <= n <= 10^5
     * 用min[]表示【i,n-1】中的最小值。
     */
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        Arrays.fill(min,Integer.MAX_VALUE);
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(nums[i], min[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            if (i + 2 < n && nums[i] > min[i + 2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsIdealPermutation775 isIdealPermutation775 = new IsIdealPermutation775();
        System.out.println(isIdealPermutation775.isIdealPermutation(TransformUtil.toIntArray("\n" +
                "[1,2,0,3]")));
    }
}

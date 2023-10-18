package com.lmz.algorithm_practice.contest.c;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-07-09 10:33
 */
public class MaximumJumps {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f,-n);
        f[0]=0;
        for (int j = 0; j < n; j++) {
            for(int i = 0;i < j; i++){
                if(Math.abs(nums[j] - nums[i]) <= target) {
                    f[j] = Math.max(f[j],f[i] + 1);
                }
            }
            //System.out.println(Arrays.toString(f));
        }
        return f[n-1] <= 0 ? -1 : f[n-1];
    }

    public static void main(String[] args) {
        MaximumJumps maximumJumps = new MaximumJumps();
        //System.out.println(maximumJumps.maximumJumps(TransformUtil.toIntArray("[1,3,6,4,1,2]"), 2));
        System.out.println(maximumJumps.maximumJumps(TransformUtil.toIntArray("[0,2,1,3]"), 1));
    }
}

package com.lmz.algorithm.contest.c;

import com.lmz.my.leetcode.TransformUtil;

/**
 * @author: limingzhong
 * @create: 2023-07-09 10:48
 */
public class MaxNonDecreasingLength {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        //int[] ans = new int[n];
        int[][] f = new int[n][2];
        f[0][0] = 1;
        f[0][1] = 1;
        int ans = 1;
        for(int i = 1; i < n; i++){
            f[i][1] = f[i][0] = 1;

            if(nums1[i] >= nums1[i-1]){
                f[i][0] = Math.max(f[i-1][0] + 1,f[i][0]);
            }
            if(nums1[i] >= nums2[i-1]){
                f[i][0] = Math.max(f[i-1][1] + 1,f[i][0]);
            }

            if(nums2[i] >= nums1[i-1]){
                f[i][1] = Math.max(f[i-1][0] + 1,f[i][1]);
            }
            if(nums2[i] >= nums2[i-1]){
                f[i][1] = Math.max(f[i-1][1] + 1,f[i][1]);
            }
            ans = Math.max(ans,Math.max(f[i][0],f[i][1]));
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxNonDecreasingLength maxNonDecreasingLength = new MaxNonDecreasingLength();
        System.out.println(maxNonDecreasingLength.maxNonDecreasingLength(TransformUtil.toIntArray("[2,3,1]"),
                TransformUtil.toIntArray("[1,2,1]")));
    }
}

package com.lmz.algorithm.dp;

import com.lmz.my.leetcode.TransformUtil;

public class Rob231 {
    /**
     * 因为首位相连，
     * 则将nums分为nums[0,n-2],nums[1,n-1],
     * 分别用f1[i],f2[i]表示以[0,i],[1,i]结尾的最大值
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] f = new int[n+2];
        for(int i = 0; i < n - 1; i++){ //不选尾
            f[i+2] = Math.max(f[i+1],f[i] + nums[i]);
        }
        int[] f2 = new int[n+2];
        for(int i = 1; i < n; i++){ //不选头
            f2[i+2] = Math.max(f2[i+1],f2[i] + nums[i]);
        }
        return Math.max(f[n],f2[n+1]);
    }

    public static void main(String[] args) {
        Rob231 rob231 = new Rob231();
        testCase(rob231, "[2,3,2]", 3);
        testCase(rob231, "[1,2,3,1]", 4);
        testCase(rob231, "[1,2,3]", 3);
        testCase(rob231, "[10,1,2,3,11]", 13);
        testCase(rob231, "[2,3]", 3);
        testCase(rob231, "[1,3,1,3,100]", 103);
    }

    private static void testCase(Rob231 rob231, String s, int i) {
        System.out.println(rob231.rob(TransformUtil.toIntArray(s)));
        boolean sucess = rob231.rob(TransformUtil.toIntArray(s)) == i;
        System.out.println(sucess);
        if(!sucess){
            System.err.println(false);
        }
    }
}

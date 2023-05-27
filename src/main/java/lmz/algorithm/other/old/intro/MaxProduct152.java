package lmz.algorithm.other.old.intro;

import lmz.my.leetcode.TransformUtil;

public class MaxProduct152 {
    /**
     * 因为有符号存在，则可以记录一个最小乘积结果值
     * f1[i]表示以i结尾的最大乘积
     * f2[i]表示以i结尾的最小乘积
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] f1 = new int[n];
        int[] f2 = new int[n];
        int maxVal = nums[0];
        f1[0] = f2[0] = nums[0];
        for(int i = 1; i < n; i++){
            f1[i] = Math.max(nums[i],Math.max(f1[i-1]*nums[i],f2[i-1]*nums[i]));
            f2[i] = Math.min(nums[i],Math.min(f1[i-1]*nums[i],f2[i-1]*nums[i]));
            maxVal = Math.max(f1[i],maxVal);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        MaxProduct152 maxProduct = new MaxProduct152();
        //testCase(maxProduct, "[2,3,-2,4]", 6);
        //testCase(maxProduct, "[-2,0,-1]", 0);
        testCase(maxProduct, "[-2,-3,-4,-2]", 48);
    }

    private static void testCase(MaxProduct152 maxProduct, String s, int i) {
        System.out.println(maxProduct.maxProduct(TransformUtil.toIntArray(s)));
        System.out.println(maxProduct.maxProduct(TransformUtil.toIntArray(s)) == i);
    }
}

package codeofli.leetcode.dp.intro.array.ring;

import codeofli.my.leetcode.StringTransformUtil;

public class MaxSubarraySumCircular918 {
    /**
     * leetcode：
     * 直接两种情况，1：最大数组和在中间，和平时一样解法
     * 2：最大数组和是跨越头尾，回头了， 麻烦第二种，从两边出发往中间靠拢必须都是最大，
     * 那就说明中间段就是最小，找最小不就行了，
     */
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        int maxSum = f[0],sum = nums[0];
        for (int i = 1; i < n; i++) {
            f[i] =nums[i] +  Math.max(f[i-1],0);
            maxSum = Math.max(maxSum,f[i]);
            sum += nums[i];
        }
        //找到中间段最小值
        int minSum = 0; //
        for (int i = 1; i < n-1; i++) {
            f[i] =nums[i] +  Math.min(f[i-1],0);
            minSum = Math.min(minSum,f[i]);
        }
        return Math.max(sum- minSum,maxSum);
    }

    /**
     * error：
     * f[i]表示以i结尾的最大子序列之和，
     * 因为是环形，则需要一个记录最大子序列开始的位置
     * fMap[i]=x,表示f[i]是[x,i]序列之和,当x == i % n 结束；
     */
    public int maxSubarraySumCircular1(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] fMap = new int[n];
        f[0] = nums[0];
        fMap[0] = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; fMap[i] != i; i = (i + 1) % n) {
            int temp = f[i - 1] + nums[i];
            if (nums[i] > temp) {
                f[i] = nums[i];
                fMap[i] = i; // 更新开始起点
            } else {
                f[i] = temp;
            }
            maxSum = Math.max(maxSum, f[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubarraySumCircular918 maxSubarraySumCircular918 = new MaxSubarraySumCircular918();
        testCase(maxSubarraySumCircular918, "[1,-2,3,-2]", 3);
        testCase(maxSubarraySumCircular918, "[5,-3,5]", 10);
        testCase(maxSubarraySumCircular918, "[-1,5,-3,5]", 9);
        testCase(maxSubarraySumCircular918, "[-2]", -2);
    }

    private static void testCase(MaxSubarraySumCircular918 maxSubarraySumCircular918, String s, int i) {
        System.out.println(maxSubarraySumCircular918.maxSubarraySumCircular(StringTransformUtil.toIntArray(s)));
        System.out.println(maxSubarraySumCircular918.maxSubarraySumCircular(StringTransformUtil.toIntArray(s)) == i);
    }
}

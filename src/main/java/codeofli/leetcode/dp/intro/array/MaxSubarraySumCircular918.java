package codeofli.leetcode.dp.intro.array;

import codeofli.leetcode.dp.intro.MaxSubArray53;
import codeofli.my.leetcode.TransformUtil;

public class MaxSubarraySumCircular918 {
    /**
     * f[i]表示以i结尾的最大子序列之和，
     * 因为是环形，则需要一个记录最大子序列开始的位置
     * fMap[i]=x,表示f[i]是[x,i]序列之和,当x == i % n 结束；
     */
    public int maxSubarraySumCircular(int[] nums) {
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
        //System.out.println(maxSubarraySumCircular918.maxSubarraySumCircular(TransformUtil.toIntArray("[1,-2,3,-2]")));
        //System.out.println(maxSubarraySumCircular918.maxSubarraySumCircular(TransformUtil.toIntArray("[1,-2,3,-2]")) == 3);

        System.out.println(maxSubarraySumCircular918.maxSubarraySumCircular(TransformUtil.toIntArray("[5,-3,5]")));
        System.out.println(maxSubarraySumCircular918.maxSubarraySumCircular(TransformUtil.toIntArray("[5,-3,5]")) == 10);

        System.out.println(maxSubarraySumCircular918.maxSubarraySumCircular(TransformUtil.toIntArray("[-1,5,-3,5]")));
        System.out.println(maxSubarraySumCircular918.maxSubarraySumCircular(TransformUtil.toIntArray("[-1,5,-3,5]")) == 9);
    }
}

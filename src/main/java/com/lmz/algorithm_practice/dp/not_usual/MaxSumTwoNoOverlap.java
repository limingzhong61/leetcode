package com.lmz.algorithm_practice.dp.not_usual;

/**
 * @author: limingzhong
 * @create: 2023-04-26 10:12
 */
public class MaxSumTwoNoOverlap {
    class Solution {
        /**
         * 前缀和
         */
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            int n = nums.length;
            int[] s = new int[n + 1];
            for (int i = 0; i < n; i++) {
                s[i + 1] = s[i] + nums[i];
            }
            //两种情况 左firstLen,右second ；枚举i前包含两个数组，其中i为第二个数组的结尾
            int maxSum1 = getMaxSum(firstLen, secondLen, n, s);
            int maxSum2 = getMaxSum(secondLen, firstLen, n, s);


            return Math.max(maxSum1,maxSum2);
        }

        private int getMaxSum(int firstLen, int secondLen, int n, int[] s) {
            int maxSum = 0,maxSumA = 0;
            for (int i = firstLen + secondLen; i <= n; i++) {
                maxSumA = Math.max(maxSumA, s[i- secondLen] - s[i - secondLen - firstLen]);
                maxSum = Math.max(maxSum, s[i] - s[i - secondLen] +maxSumA);
            }
            return maxSum;
        }
    }
}

package lmz.leetcode.other.medium;

import lmz.my.leetcode.TransformUtil;

/**
 * @author: limingzhong
 * @create: 2023-05-23 15:57
 */
public class MaxSumTwoNoOverlap {
    static class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            int n = nums.length;
            int sum1 = 0;
            for (int i = 0; i < firstLen; i++) {
                sum1 += nums[i];
            }
            int maxSum = 0;
            int max = getMax(nums, secondLen, 0, 0);
            max = Math.max(max, getMax(nums, secondLen, firstLen + 1, n));
            maxSum = max + sum1;
            // [right-firstLen,right)
            for (int right = firstLen; right < n; right++) {
                sum1 += nums[right] - nums[right - firstLen];
                max = 0; // 重置前面的
                max = getMax(nums, secondLen, 0, right - firstLen + 1);
                max = Math.max(max, getMax(nums, secondLen, right+1, n));
                maxSum = Math.max(maxSum,max+sum1);
                //System.out.printf("%d,%d,%d\n",sum1,max,maxSum);
            }
            return maxSum;
        }

        // 获取 [start,end) len 最大值
        private static int getMax(int[] nums, int len, int start, int end) {
            int sum2 = 0;
            for (int j = start; j < start + len && j < end; j++) {
                sum2 += nums[j];
            }
            int max = sum2;
            // System.out.printf("%d,%d,\n",sum2,max);
            for (int j = start + len; j < end; j++) {
                sum2 +=  nums[j] - nums[j - len];
                max = Math.max(max, sum2);
                //System.out.printf("%d,%d,%d,%d\n",nums[j] , nums[j - len],sum2,max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSumTwoNoOverlap(TransformUtil.toIntArray("[2,1,5,6,0,9,5,0,3,8]")
                , 4, 3));
    }
}

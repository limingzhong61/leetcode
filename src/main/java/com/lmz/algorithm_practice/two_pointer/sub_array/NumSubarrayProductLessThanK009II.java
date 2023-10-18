package com.lmz.algorithm_practice.two_pointer.sub_array;

public class NumSubarrayProductLessThanK009II {

    class Solution {
        /**
         * 同向双指针： r固定，枚举左端点
         */
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            //1 <= nums[i] <= 1000
            if (k <= 1) return 0;
            int n = nums.length, left = 0, product = 1, res = 0;
            for (int right = 0; right < n; right++) {
                product *= nums[right];
                while (product >= k) {  //不满足要求
                    product /= nums[left++];
                }
                res += right - left + 1;
            }
            return res;
        }
    }

    /**
     * 双指针，l固定，确定r,每次以l为起点的< k 的连续子数组[l,r]个个数为 r -l + 1
     * r每次肯定 > 之前的r'. O(n)
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length;
        int res = 0;
        for (; l < n; ) {
            int product = nums[l];
            if (r < l) r = l;
            while (r + 1 < n && product * nums[r + 1] < k) {
                product *= nums[r + 1];
                r++;
            }
            int len = r - l + 1;
            res += len;
            // System.out.printf("%d,%d,%d\n",l,r,len);
            l++;
        }
        return res;
    }
}

package lmz.leetcode.two_points.sub_array;

public class NumSubarrayProductLessThanK009II {
    /**
     * 双指针，l固定，确定r,每次以l为起点的< k 的连续子数组[l,r]个个数为 r -l + 1
     * r每次肯定 > 之前的r'. O(n)
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length;
        int res = 0;
        for (; l < n; ) {
            int product = nums[l];
            if(r < l ) r = l;
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

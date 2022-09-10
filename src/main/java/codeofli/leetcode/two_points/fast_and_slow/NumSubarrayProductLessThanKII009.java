package codeofli.leetcode.two_points.fast_and_slow;

public class NumSubarrayProductLessThanKII009 {
    /**
     * 双指针
     * 0 <= k <= 10^6
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left  = 0,right = 0;
        int product = nums[left];
        int cnt = 0;
        for(;;){
            while(product < k){
                cnt++;
                right++;
                product *= nums[right];
            }

        }
    }
}

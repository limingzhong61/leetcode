package com.lmz.algorithm_practice.find.binary_search;

public class SmallestDivisor1286 {
    /**
     * 单调函数检查--二分查找
     * false，true，右边界
     */
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1,high = 1000000;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(check(nums,threshold,mid)){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean check(int[] nums,int threshold, int x) {
        int sum = 0;
        for(int num : nums){
            int need = num / x;
            // 向上取整
            if (num % x != 0) {
                need++;
            }
            sum += need;
            if (sum > threshold) {
                return false;
            }
        }
        return true;
    }

}

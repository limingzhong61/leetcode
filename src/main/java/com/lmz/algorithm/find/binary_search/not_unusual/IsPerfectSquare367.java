package com.lmz.algorithm.find.binary_search.not_unusual;

public class IsPerfectSquare367 {
    /**
     * 二分查找
     */
    public boolean isPerfectSquare(int num) {
        //相乘，会溢出
        long low = 1, high = num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sqrt = mid * mid;
            if (sqrt == num) {
                return true;
            } else if (sqrt > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return  false;
    }
}

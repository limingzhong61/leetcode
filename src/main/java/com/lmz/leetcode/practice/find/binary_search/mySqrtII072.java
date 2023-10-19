package com.lmz.leetcode.practice.find.binary_search;

/**
 * @author: limingzhong
 * @create: 2023-03-23 17:39
 */
public class mySqrtII072 {
    /**
     * <=,<=,<,<
     */
    public int mySqrt(int x) {
        int low = 0, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid <= x){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }
}

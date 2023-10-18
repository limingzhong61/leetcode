package com.lmz.algorithm_practice.find.binary_search.not_unusual;

public class MySqrt69 {
    /**
     * 找到分界点左边界
     */
    public int mySqrt(int x) {
        int low = 0, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sqrt = (long)mid * mid;
            if (sqrt > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        MySqrt69 mySqrt69 = new MySqrt69();
        System.out.println(mySqrt69.mySqrt(1234567891));
    }
}

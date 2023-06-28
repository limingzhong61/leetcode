package lmz.algorithm.find.binary_search.not_unusual.function_calculate;

public class ArrangeCoins441 {
    /**
     * 二分查找,找到一个f(x)<= n的最大值,其中f(x)= x * (x-1)/2;
     * 找到左边界
     */
    public int arrangeCoins(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long f = (long) mid * (mid + 1) / 2;
            if (f > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}

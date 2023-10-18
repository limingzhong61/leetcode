package com.lmz.algorithm_practice.find.binary_search.max_or_min_judge;

/**
 * @author: limingzhong
 * @create: 2023-01-04 12:45
 */
public class MaxValue1802 {

    /**
     * lc简化计算sum
     */
    public int maxValue(int n, int index, int maxSum) {
        long l = 0, r = maxSum;
        //因为数组中所有的数均为正整数，所以减去n，剩余的表示可以填的数
        maxSum -= n;
        while(l<r){
            //m表示index指向位置的高度
            long m = l+r+1>>1;

            //计算当index的位置高度为m时，数组所有元素的和
            long count = m*m;
            //如果左边越界，就减去左边多的
            if(m>index) count -= (m-index-1)*(m-index)/2;
            //如果右边越界，就减去右边多的
            if(m>(n-index)) count -= (m-(n-index-1)-1)*(m-(n-index-1))/2;

            //二分法判断
            if(count>maxSum) r = m-1;
            else l = m;
        }
        return (int)l+1;
    }
    /**
     * 二分查找：注意溢出和上下界的范围
     */
    public int maxValue1(int n, int index, int maxSum) {
        int low = 1, high = maxSum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(n, index, maxSum, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private boolean check(int n, int index, int maxSum, int x) {
        int lLen = index, rLen = n - index - 1;
        long sum = x; //中间为x,然后依次递减，故两侧最大为x-1
        sum += getSum(x - 1, lLen);
        sum += getSum(x - 1, rLen);
        return sum <= maxSum;
    }

    private static long getSum(int x, int lLen) {
        long sum = 0;
        if (lLen >= x) {
            sum += (long) x * (x + 1) / 2;
            sum += lLen - x; // 补齐为1
        } else {
            sum += (long) lLen * x + (long) lLen * (lLen - 1) / 2 * (-1);
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxValue1802 maxValue1802 = new MaxValue1802();
        //testCase(maxValue1802, 3, 2, 18, 7);
        testCase(maxValue1802, 7, 0, 930041194, 132863030);
    }

    private static void testCase(MaxValue1802 maxValue1802, int n, int index, int maxSum, int x) {
        System.out.println(maxValue1802.maxValue(n, index, maxSum));
        System.out.println(maxValue1802.maxValue(n, index, maxSum) == x);
    }
}

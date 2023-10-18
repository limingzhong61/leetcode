package com.lmz.algorithm_practice.other.old.dp;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NthUglyNumber {
    /**
     * leetcode:最小堆
     * 初始时堆为空。首先将最小的丑数 11 加入堆。
     * 每次取出堆顶元素 x，则 x 是堆中最小的丑数，由于 2x,3x,5x 也是丑数，因此将 2x,3x,5x 加入堆。
     * 上述做法会导致堆中出现重复元素的情况。为了避免重复元素，可以使用哈希集合去重，避免相同元素多次加入堆。
     * 在排除重复元素的情况下，第 nn 次从最小堆中取出的元素即为第 nn 个丑数。
     */
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        //哈希集合去重
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        heap.add(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curVal = heap.poll();
            ugly = (int) curVal;
            for (int factor : factors) {
                long next = curVal * factor;
                if (set.add(next)) {
                    heap.add(next);
                }
            }
        }
        return ugly;
    }

    /**
     * leetcode思路：
     * 三个指针
     * 1 <= n <= 1690
     * 其实就是指针对应的数值用掉了，谁就+1更新一下数值，其余指针对应的数值进入下一轮比较。
     * 1）假设n是第n个丑数，那么1代表第一个丑数，2代表第二个丑数...
     *
     * 2）a代表1~n丑数当中，从小到大，第一个乘以2之后大于n的丑数
     * b代表1~n丑数当中，从小到大，第一个乘以3之后大于n的丑数
     * c代表1~n丑数当中，从小到大，第一个乘以5之后大于n的丑数
     *
     * 第n+1个丑数一定来源于之前1~n个丑数当中的数乘以2或者乘以3或者乘以5
     * 换句话说，我们要找的是内阁最小的超过第n丑数的数，那么这个数一定来自于a b 或者c
     * 现在明白为什么要这么写状态方程了吧！所谓的三指针就是这个意思，题目变一下，如果要你找2，3，4，5符合条件的数呢，设置四个指针即可。
     */
    public int nthUglyNumber1(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n1 = dp[a] * 2, n2 = dp[b] * 3, n3 = dp[c] * 5;
            dp[i] = Math.min(n1, Math.min(n2, n3));
            if (dp[i] == n1) {
                a++;
            }
            if (dp[i] == n2) {
                b++;
            }
            if (dp[i] == n3) {
                c++;
            }
        }
        return dp[n - 1];
    }
    ///**
    // * 思路：类似于埃氏素数筛选法：
    // * 不行，会超过内存限制
    // * n 不超过1690。
    // * dp[i]
    // */
    //public int nthUglyNumber(int n) {
    //    int size =  5000;
    //    boolean[] mark = new boolean[size + 1];
    //    mark[1] = true;
    //    int[] factor = new int[]{2, 3, 5};
    //    for (int i = 0; i < factor.length; i++) {
    //        for (int j = factor[i]; j <= size; j += factor[i]) {
    //            mark[j] = true;
    //        }
    //    }
    //    int cnt = 0;
    //    for (int i = 1; i <= size; i++) {
    //        cnt += mark[i] ? 1 : 0;
    //        if(cnt == n){
    //            return i;
    //        }
    //    }
    //    return cnt;
    //}

    public static void main(String[] args) {
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        System.out.println(nthUglyNumber.nthUglyNumber(10));
        System.out.println(nthUglyNumber.nthUglyNumber(10) == 12);
        System.out.println(nthUglyNumber.nthUglyNumber(1690));
        System.out.println(nthUglyNumber.nthUglyNumber(1690) == 2123366400);
    }
}

package com.lmz.algorithm.find.binary_search.easy;

import com.lmz.my.leetcode.TransformUtil;

import java.awt.Point;
import java.util.Arrays;

public class MaxProfitAssignment826 {
    /**
     * 二分查找+双指针
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Point[] pair = new Point[n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Point(difficulty[i], profit[i]);
        }
        Arrays.sort(pair, (a, b) -> a.x - b.x);
        // 有可能，diff小，但是收益却很大
        int sum = 0, idx = 0, maxProfit = 0;
        Arrays.sort(worker);
        // idx 指针,因为work有序，则找到的diff也是递增有序的，则可以利用前一个work，在此基础上查找
        for (int w : worker) {
            while (idx < n && pair[idx].x <= w) {
                maxProfit = Math.max(pair[idx].y, maxProfit);
            }
            sum += maxProfit;
        }
        return sum;
    }

    /**
     * 二分查找<= x的最大值。
     * T, F,左边界
     *
     * @Return 注意pos = -1,有可能比数组中所有数字都小
     */
    private int smallerNumberIndexByBS(Pair<Integer, Integer>[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int pos = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].val1 > x) {
                high = mid - 1;
            } else { //此时 <= x
                pos = mid;
                low = mid + 1;
            }
        }
        return pos;
    }

    public int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length, m = worker.length;
        Pair<Integer, Integer>[] pair = new Pair[n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Pair<>(difficulty[i], profit[i]);
        }
        int maxProfit = 0;
        Arrays.sort(pair, (a, b) -> a.val1 - b.val1);
        // 有可能，diff小，但是收益却很大
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(pair[i].val2, maxProfit);
            pair[i].val2 = maxProfit;
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int idx = smallerNumberIndexByBS(pair, worker[i]);
            if (idx < 0) {
                continue;
            }
            //System.out.println(idx + ":" + pair[idx]);
            sum += pair[idx].val2;
        }
        return sum;
    }

    /**
     * 二分查找<= x的最大值。
     * T, F,左边界
     *
     * @Return 注意pos = -1,有可能比数组中所有数字都小
     */
    private int smallerNumberIndexByBS1(Pair<Integer, Integer>[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int pos = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].val1 > x) {
                high = mid - 1;
            } else { //此时 <= x
                pos = mid;
                low = mid + 1;
            }
        }
        return pos;
    }

    /**
     * 通用泛型Pair类型
     */
    public class Pair<V1, V2> {
        public V1 val1;
        public V2 val2;

        public Pair() {
        }

        public Pair(V1 val1, V2 val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val1=" + val1 +
                    ", val2=" + val2 +
                    '}';
        }
    }

    public static void main(String[] args) {
        MaxProfitAssignment826 maxFrequency1838 = new MaxProfitAssignment826();


        System.out.println(maxFrequency1838.maxProfitAssignment(TransformUtil.toIntArray("[2,4,6,8,10]"),
                TransformUtil.toIntArray("[10,20,30,40,50]"),
                TransformUtil.toIntArray("[4,5,6,7]")));
    }
}

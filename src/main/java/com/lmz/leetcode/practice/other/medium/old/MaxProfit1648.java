package com.lmz.leetcode.practice.other.medium.old;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;

public class MaxProfit1648 {
    /**
     * 先找到剩余数量最大的可能x：
     * true,false,左边界
     * 然后从最大数目i1取i1-x个。。。一直取到orders个
     * 注意：x剩余数量最大可能，最后下边界是需要x+1的
     */
    public int maxProfit(int[] inventory, int orders) {
        //1 <= inventory.length <= 105
        //1 <= inventory[i] <= 109
        int left = 0, right = 1000000000;
        Arrays.sort(inventory);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(inventory, orders, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // max最后是取不到的，需要+1
        int max = right + 1;
        long res = 0;
        final int MOD = 1000000007;
        for(int i = inventory.length - 1; i >= 0; i--){
            long x = inventory[i];
            if(x > max){
                long size = x - max;
                res = (res + (x + max + 1) * size / 2) % MOD;  //// 取到 max + 1
                orders -= size;
            }
        }
        // 剩余补齐为max, 特殊处理下边界
        res = (res + (long) orders * max) % MOD;
        return (int) res;
    }

    private boolean check(int[] inventory, int orders, int mid) {
        for(int i = inventory.length - 1; i >= 0; i--){
            int x = inventory[i];
            if (x > mid) {
                orders -= x - mid;
                if(orders <= 0){
                    return true;
                }
            }
        }
        return orders <= 0;
    }

    public static void main(String[] args) {
        MaxProfit1648 maxProfit1648 = new MaxProfit1648();
        testCase(maxProfit1648, "[497978859,167261111,483575207,591815159]", 836556809, 373219333);
        testCase(maxProfit1648, "[2,5]", 4, 14);
        testCase(maxProfit1648, "[1000,1000]", 2, 2000);
        testCase(maxProfit1648, "[3,5]", 6, 19);
        testCase(maxProfit1648, "[2,8,4,10,6]", 20, 110);
        testCase(maxProfit1648, "[1000000000]", 1000000000, 21);
    }

    private static void testCase(MaxProfit1648 maxProfit1648, String original, int orders, int x) {
        System.out.println(maxProfit1648.maxProfit(TransformUtil.toIntArray(original), orders));
        System.out.println(maxProfit1648.maxProfit(TransformUtil.toIntArray(original), orders) == x);
    }

}

package com.lmz.algorithm_practice;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

class Solution {
    static final int mod = (int)1e9 + 7;
    public int maxProfit(int[] inventory, int orders) {
        // wuzhenyu
        int l = 0, r = 0;
        long ans = 0;
        for(int num: inventory) if (num > r) r = num;
        while(l < r) { // 二分找下边界
            int mid = l + (r - l) / 2;
            if(check(inventory, mid, orders)) l = mid + 1;
            else r = mid;
        }
        for(int num: inventory) { // 取到下边界之上一个值
            if(num > l) {
                ans += (num + l + 1L) * (num - l) / 2; // 取到 l + 1
                orders -= num - l; // 取球
            }
        }
        ans += (l + 0L) * orders; // 剩余补齐, 特殊处理下边界
        return (int)(ans % mod);
    }

    // 以price为底线
    public boolean check(int[] nums, int price, int orders){
        int sum = 0;
        for(int num: nums) {
            sum += Math.max(num - price, 0);
            if (sum >= orders) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(TransformUtil.toIntArray("[497978859,167261111,483575207,591815159]"), 836556809));
    }
}

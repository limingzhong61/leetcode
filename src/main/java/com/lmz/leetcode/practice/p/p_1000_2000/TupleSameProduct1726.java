package com.lmz.leetcode.practice.p.p_1000_2000;

import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-10-19 15:39
 */
public class TupleSameProduct1726 {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = nums[i] * nums[j];
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }
        int ans = 0;
        for (var cnt : map.values()) {
            // cnt 中取2
            ans += cnt * (cnt - 1) / 2 * 8;
        }
        return ans;
    }
}

package com.lmz.algorithm.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-01-17 12:06
 */
public class CountNicePairs1814 {
    /**
     * math,等式变换
     * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])等价于 nums[i] -rev(nums[i]) == nums[j] -rev(nums[j])
     * 本质上就是求差相同的组合数
     */
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int val = num - rev(num);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int mod = (int) (1e9 + 7);
        long sum = 0;
        for (var entry : map.entrySet()) {
            long cnt = entry.getValue();
            sum = (sum + cnt * (cnt - 1) / 2) % mod;
        }
        return (int) sum;
    }

    private int rev(int x) {
        int val = 0;
        while (x > 0) {
            val = val * 10 + x % 10;
            x /= 10;
        }
        return val;
    }
}

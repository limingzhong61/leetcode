package com.lmz.my.leetcode.sub_array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-03-16 10:26
 */
public class CountSubarrays2488 {
    /**
     * 前缀和
     * >k 1, =k 0, <k -1
     */
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int kIdx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                kIdx = i;
                break;
            }
        }

        int[] preSum = new int[n + 1];
        int sum = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        // 初始[left,right]没有元素为0
        counter.put(0,1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += sign(nums[i] - k);
            if (i < kIdx) {
                counter.put(sum, counter.getOrDefault(sum, 0) +1);
            } else {
                int v1 = counter.getOrDefault(sum, 0);
                int v2 = counter.getOrDefault(sum - 1, 0);
                //counter.put(sum, counter.getOrDefault(sum, 0) + 1);
                res += v1 + v2;
            }
        }
        return res;
    }

    private int sign(int num) {
        if (num == 0) {
            return 0;
        }
        return num > 0 ? 1 : -1;
    }
}

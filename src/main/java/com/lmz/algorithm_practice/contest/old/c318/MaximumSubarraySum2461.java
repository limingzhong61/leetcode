package com.lmz.algorithm_practice.contest.old.c318;

import java.util.HashMap;

/**
 * @author: codeofli
 * @create: 2022-11-06 10:40
 */
public class MaximumSubarraySum2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        long sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }
        int n = nums.length;
        if (map.size() == k) {
            max = sum;
        }
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            map.put(nums[i - k], map.getOrDefault(nums[i - k], 0) - 1);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i -k]) == 0){
                map.remove(nums[i-k]);
            }
            if (map.size() == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}

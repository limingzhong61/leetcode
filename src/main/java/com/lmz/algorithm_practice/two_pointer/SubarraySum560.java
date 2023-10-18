package com.lmz.algorithm_practice.two_pointer;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum560 {
    /**
     * 前缀和+hashmap
     */
    public int subarraySum(int[] nums, int k) {
        //1 <= nums.length <= 2 * 104
        int len = nums.length;
        int[] f = new int[len + 1];
        Map<Integer, Integer> sumCnt = new HashMap<>();
        int cnt = 0;
        sumCnt.put(0,1); // 便于处理 sum[0,i]的情况
        for (int i = 1; i <= len; i++) {
            f[i] = f[i - 1] + nums[i - 1];
            cnt += sumCnt.getOrDefault(f[i] - k, 0);
            sumCnt.put(f[i], sumCnt.getOrDefault(f[i], 0)+1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        SubarraySum560 subarraySum560 = new SubarraySum560();
        System.out.println(subarraySum560.subarraySum(TransformUtil.toIntArray("[1,1,1]"), 2));
        System.out.println(subarraySum560.subarraySum(TransformUtil.toIntArray("[1,1,1]"), 2) == 2);
        System.out.println(subarraySum560.subarraySum(TransformUtil.toIntArray("[-1,-1,1]"), 0));
        System.out.println(subarraySum560.subarraySum(TransformUtil.toIntArray("[-1,-1,1]"), 0) == 1);
    }
}

package com.lmz.algorithm_practice.other.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: limingzhong
 * @create: 2023-06-04 10:40
 */
public class DistinctAverages2465 {
    /**
     * 给你一个下标从 0 开始长度为 偶数 的整数数组 nums 。
     * 把这两个数的和放入哈希表中（不需要除以 2，因为只计算不同平均值的个数，两个平均值不同，等价于两数之和不同）。
     */
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for(int left = 0,right = nums.length -1; left < right; left++,right--){
            set.add(nums[left] + nums[right]);
        }
        return set.size();
    }
}

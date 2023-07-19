package com.lmz.util.solution_template.find;

/**
 * @author: limingzhong
 * @create: 2023-07-19 10:07
 */
public class FindUtil {
    /**
     * 在有序数组中找到<= target 的最大值的idx
     *
     * @param nums   升序数组
     * @param target
     * @return idx
     */
    int findMaxIdxInSmallerEqual(int[] nums, int target) {
        // 最小值
        if (target < nums[0]) return -1;
        // 经过判断 nums[0] <= target
        int idx = 0;
        while (idx + 1 < nums.length && nums[idx + 1] <= target) idx++;
        return idx;
    }
}

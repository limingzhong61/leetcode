package com.lmz.leetcode.practice.other.old.find;

import java.util.HashSet;
import java.util.Set;

public class findRepeatNumber03 {
    /**
     * leetcode:原地交换，
     * 题目说明尚未被充分使用，即 在一个长度为 n 的数组 nums 里的所有数字都在 0 ~ n-1 的范围内 。
     * 此说明含义：数组元素的 索引 和 值 是 一对多 的关系。
     * nums[i](值)，nums[nums[i]]:索引nums[i]所对应的值
     */
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            //题目条件：必然存在一个index（i）对应多个值
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }

    /**
     * my:set
     */
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return 0;
    }
}

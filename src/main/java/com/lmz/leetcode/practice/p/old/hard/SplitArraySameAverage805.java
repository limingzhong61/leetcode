package com.lmz.leetcode.practice.p.old.hard;

import java.util.stream.IntStream;

/**
 * @author: codeofli
 * @create: 2022-11-14 10:12
 */
public class SplitArraySameAverage805 {
    /**
     * 1 <= nums.length <= 30
     * 0 <= nums[i] <= 10^4
     */
    public boolean splitArraySameAverage(int[] nums) {
        int sum = IntStream.of(nums).sum();
        double avg = IntStream.of(nums).average().getAsDouble();
        return true;
    }
}

package com.lmz.algorithm_practice.contest.old.c_315;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.HashSet;

public class CountDistinctIntegers {
    /**
     * 1 <= nums[i] <= 106
     */
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            String s = String.valueOf(x);
            set.add(Integer.parseInt(s));
            StringBuilder sb = new StringBuilder(s);
            String reverse = sb.reverse().toString();
            set.add(Integer.parseInt(reverse));
        }
        return set.size();
    }

    public static void main(String[] args) {
        CountDistinctIntegers countDistinctIntegers = new CountDistinctIntegers();
        System.out.println(countDistinctIntegers.countDistinctIntegers(TransformUtil.toIntArray("[1,13,10,12,31]")));
    }
}

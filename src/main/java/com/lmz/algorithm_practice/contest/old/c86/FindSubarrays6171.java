package com.lmz.algorithm_practice.contest.old.c86;

import java.util.HashSet;
import java.util.Set;

public class FindSubarrays6171 {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //2 <= nums.length <= 1000
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int sum = nums[i] + nums[i - 1];
            if (set.contains(sum)) {
                return true;
            } else {
                set.add(sum);
            }
        }
        return false;
    }
}

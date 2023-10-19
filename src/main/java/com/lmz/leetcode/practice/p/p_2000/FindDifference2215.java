package com.lmz.leetcode.practice.p.p_2000;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: limingzhong
 * @create: 2023-08-08 11:23
 */
public class FindDifference2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = IntStream.of(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = IntStream.of(nums2).boxed().collect(Collectors.toSet());

        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int x : nums1) {
            if (!set2.contains(x))
                set.add(x);
        }
        ans.add(set.stream().toList());

        set = new HashSet<>();
        for (int x : nums2) {
            if (!set1.contains(x))
                set.add(x);
        }
        ans.add(set.stream().toList());

        return ans;
    }
}

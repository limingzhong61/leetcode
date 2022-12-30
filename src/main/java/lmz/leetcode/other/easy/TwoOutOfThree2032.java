package lmz.leetcode.other.easy;

import java.util.*;

/**
 * @author: limingzhong
 * @create: 2022-12-29 14:20
 */
public class TwoOutOfThree2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (var x : nums1) {
            set.add(x);
        }
        for (var x : nums2) {
            if (set.contains(x)) {
                res.add(x);
            }
        }
        for (var x : nums3) {
            if (set.contains(x)) {
                res.add(x);
            }
        }
        set.clear();
        for (var x : nums2) {
            set.add(x);
        }
        for (var x : nums3) {
            if (set.contains(x)) {
                res.add(x);
            }
        }
        List<Integer> res1 = new ArrayList<>();
        res1.addAll(res);
        return res1;
    }
}

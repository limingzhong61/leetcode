package lmz.leetcode.other.easy.old;

import lmz.my.leetcode.TransformUtil;

import java.util.*;

/**
 * @author: limingzhong
 * @create: 2022-10-22 10:21
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums1) {
            set.add(x);
        }
        Set<Integer> inter = new HashSet<>();
        for (int x : nums2) {
            if (set.contains(x)) {
                inter.add(x);
            }
        }
        int[] res = new int[inter.size()];
        int idx = 0;
        for(int x : inter){
            res[idx++] = x;
        }
        return res;
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        System.out.println(Arrays.toString(intersection.intersection(TransformUtil.toIntArray("[1,2,2,1]"),
                TransformUtil.toIntArray("[2,2]"))));
    }
}

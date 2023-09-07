package com.lmz.algorithm.p.p_2000;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: limingzhong
 * @create: 2023-09-05 9:36
 */
public class MinNumber2605 {
    /**
     解释：找到两个数组相同的数字，并返回最小值；如果没有相同的数字，那么返回”两个数组中各取一个能够组合成的最小数字“。
     */
    public int minNumber(int[] nums1, int[] nums2) {
        int n1 = nums1.length,n2 = nums2.length;
        Set<Integer> set = IntStream.of(nums1).boxed().collect(Collectors.toSet());
        int min = Integer.MAX_VALUE;
        for(int x : nums2){
            if(set.contains(x)){
                min = Math.min(x,min);
            }
        }
        if(min != Integer.MAX_VALUE){
            return min;
        }
        int min1 = IntStream.of(nums1).min().getAsInt();
        int min2 = IntStream.of(nums2).min().getAsInt();

        min = Math.min(min1,min2);
        int max = Math.max(min1,min2);

        return min * 10 + max;
    }
}

package com.lmz.leetcode.practice.p.p_1000_2000;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: limingzhong
 * @create: 2023-08-04 14:32
 */
public class KidsWithCandies1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = IntStream.of(candies).max().getAsInt();
        return IntStream.of(candies).mapToObj(x -> x + extraCandies >= max).collect(Collectors.toList());
    }
}

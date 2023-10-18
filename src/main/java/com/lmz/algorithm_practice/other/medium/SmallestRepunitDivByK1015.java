package com.lmz.algorithm_practice.other.medium;

import java.util.HashSet;

/**
 * @author: limingzhong
 * @create: 2023-05-10 11:43
 */
public class SmallestRepunitDivByK1015 {
    class Solution {
        public int smallestRepunitDivByK(int k) {
            var seen = new HashSet<Integer>();
            int x = 1 % k;
            while (x > 0 && seen.add(x))
                x = (x * 10 + 1) % k;
            return x > 0 ? -1 : seen.size() + 1;
        }
    }
}

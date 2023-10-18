package com.lmz.algorithm_practice.hash;

import java.util.HashSet;

/**
 * @author: limingzhong
 * @create: 2023-05-25 10:16
 */
public class LongestConsecutive {
    /**
     * 1.利用set去重；
     * 2. 找到序列的开始：在set中x,如果存在x-1，则x不是一个序列的开始
     * 3. 枚举序列长度，如果x是序列的开始直接枚举x+1，统计长度，所有长度的最大值即为ans
     */
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int maxLen = 1;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int current = x;
                while (set.contains(current + 1)) {
                    current++;
                }
                maxLen = Math.max(maxLen,current - x +1);
            }
        }

        return maxLen;
    }
}

package com.lmz.leetcode.practice.p.medium.old;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-01-05 17:00
 */
public class FindMaxLengthII010 {
    /**
     * 前缀和+hash
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(0, -1);
        int counter = 0,maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (nums[0] == 1) {
                counter++;
            } else {
                counter--;
            }
            if(map.containsKey(counter)){
                int preIdx = map.get(counter);
                maxLen = Math.max(maxLen,i - preIdx);
            }else {
                map.put(counter,i);
            }
        }
        return maxLen;
    }
}

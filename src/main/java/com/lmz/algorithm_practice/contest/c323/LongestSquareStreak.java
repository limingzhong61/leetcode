package com.lmz.algorithm_practice.contest.c323;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSquareStreak {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashMap<Long,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put((long) nums[i],i);
        }
        int maxLen = -1;
        for(int i = 0; i < nums.length; i++){
            int len = 0;
            long start = nums[i];
            System.out.printf("%d,",start);
            while(map.containsKey(start * start)){
                start *= start;
                len++;
            }
            System.out.printf("%d\n",len);
            maxLen = Math.max(maxLen,len);
        }
       return  maxLen == 0 ? -1 : maxLen;
    }
}

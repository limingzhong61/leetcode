package com.lmz.leetcode.practice.p.p_2000;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-11-10 16:48
 * @description:
 */
public class SuccessfulPairs2300 {
    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            int n = spells.length, idx = 0;
            int[] ans = new int[n];
            for(int spell : spells){
                int cnt = 0;
                int left = 0, right = potions.length;
                while(left < right){
                    int mid = left + (right - left) / 2;
                    if((long)potions[mid] * spell < success){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                ans[idx++] = potions.length - left;
            }
            return ans;
        }
    }
}

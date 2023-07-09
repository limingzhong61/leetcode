package com.lmz.algorithm.find.binary_search.max_or_min_judge;

import java.util.HashSet;
import java.util.Set;

public class MaximumRemovals1898 {
    /**
     * 二分尝试，试出最大最小值，
     * 左边界
     */
    public int maximumRemovals(String s, String p, int[] removable) {
        int low = 0, high = removable.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (check(s, p, removable, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    /**
     * s 和 p 都由小写英文字母组成
     */
    private boolean check(String s, String p, int[] removable, int mid) {
        Set<Integer> removeSet = new HashSet<>();
        for(int i = 0; i <=  mid; i++){
            removeSet.add(removable[i]);
        }
        int pIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (removeSet.contains(i)) {
                continue;
            }
            if(s.charAt(i) == p.charAt(pIdx)){
                pIdx++;
                if(pIdx == p.length()){
                    return true;
                }
            }
        }
        return pIdx == p.length();
    }


}

package com.lmz.algorithm.other.old.primary.arrays;

import java.util.ArrayList;
import java.util.List;

public class Intersect350 {
    /**
     * my：
     * 因为数据量小[0-1000]，故直接空间换时间
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] cnt = new int[1001];
        for(int i : nums1){
            cnt[i]++;
        }
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for(int i : nums2){
            if(cnt[i] > 0){ //次数可能不止一次
                cnt[i]--;
                list.add(i);
            }
        }
        int listSize = list.size();
        int[] result = new int[listSize];
        for(int i = listSize; i > -1; --i){
            result[i] = list.get(i);
        }
        return result;
    }
}

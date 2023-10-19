package com.lmz.leetcode.practice.find;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class HIndexII {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0,high = citations.length - 1;
        int res = 0;
        while (low <= high){
            int mid = low +(high - low) /2 ;
            if(n - mid <= citations[mid]){
                res = n - mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        HIndexII hIndexII = new HIndexII();
        System.out.println(hIndexII.hIndex(TransformUtil.toIntArray("\n" +
                "[0,1,3,5,6]")));
    }
}

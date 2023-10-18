package com.lmz.algorithm_practice.contest.old.c312;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.List;

public class GoodIndices {
    /**
     * dp
     * 3 <= n <= 105
     * 1 <= nums[i] <= 106
     * 1 <= k <= n / 2
     */
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        boolean[] f = new boolean[n];
        for (int i = 0; i < n; i++) {
            f[i] = true;
        }
        for (int len = 2; len <= k; len++) {
            for (int i = 0; i < n; i++) {
                if (i - len >= 0 && i + len < n) {
                    if (f[i] && nums[i - len] >= nums[i - len + 1] && nums[i + len] >= nums[i + len - 1]) {
                        f[i] = true;
                    }else{
                        f[i] = false;
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i - k >= 0 && i + k < n) {
                if (f[i]) {
                    res.add(i);
                }
            }

        }
        return res;
    }

    ///**
    // * 3 <= n <= 105
    // * 1 <= nums[i] <= 106
    // * 1 <= k <= n / 2
    // */
    //public List<Integer> goodIndices(int[] nums, int k) {
    //    int n = nums.length;
    //    List<Integer> res = new ArrayList<>();
    //    for (int i = k; i + k < n; i++) {
    //        // 前面非递增[i-k,i-1]
    //        boolean flag = true;
    //        for (int j = i - k + 1; j <= i - 1; j++) {
    //            if (nums[j] > nums[j - 1]) {
    //                flag = false;
    //                break;
    //            }
    //        }
    //        if (!flag) {
    //            continue;
    //        }
    //        // 前面非递减[i+1,i+k]
    //        flag = true;
    //        for (int j = i + 2; j <= i + k; j++) {
    //            if (nums[j] < nums[j - 1]) {
    //                flag = false;
    //                break;
    //            }
    //        }
    //        if (!flag) {
    //            continue;
    //        }
    //        res.add(i);
    //    }
    //    return res;
    //}
    public static void main(String[] args) {
        GoodIndices goodIndices = new GoodIndices();
        System.out.println(goodIndices.goodIndices(
                TransformUtil.toIntArray("[2,1,1,1,3,4,1]"), 2));
        System.out.println(goodIndices.goodIndices(
                TransformUtil.toIntArray("[693570,409751,33944,16682,26296,545257,827687,885741,970671]"), 3));
        System.out.println(goodIndices.goodIndices(TransformUtil.toIntArray("[253747,459932,263592,354832,60715,408350,959296]"), 2));
    }
}

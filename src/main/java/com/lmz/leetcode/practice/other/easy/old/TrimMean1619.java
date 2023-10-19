package com.lmz.leetcode.practice.other.easy.old;

import java.util.Arrays;

public class TrimMean1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int trim = arr.length / 20;
        double sum = 0;
        for(int i = trim; i < len - trim; i++){
            sum += arr[i];
        }
        return  sum / (len - 2 * trim);
    }
}

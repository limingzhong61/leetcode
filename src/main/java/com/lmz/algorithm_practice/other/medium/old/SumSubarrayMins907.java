package com.lmz.algorithm_practice.other.medium.old;

/**
 * @author: codeofli
 * @create: 2022-10-28 23:23
 */
public class SumSubarrayMins907 {
    /**
     * 单调队列：
     * 找到 left  >= arr[i] < right  ，left,right为符合条件的最左最右值,
     * 记left[i]，right[i]为左右长度 left[i] = i - 下一个比arr[i]更小元素的位置;
     * @param arr
     * @return
     */
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n ; i++){

        }
        return -1;
    }
}

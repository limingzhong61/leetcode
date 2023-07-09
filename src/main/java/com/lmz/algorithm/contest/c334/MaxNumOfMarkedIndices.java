package com.lmz.algorithm.contest.c334;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-02-26 10:45
 */
public class MaxNumOfMarkedIndices {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] marked = new boolean[n];
        for(int i = n -1 ; i >= 0; i--){
            if(!marked[i]){
                int minNeed = nums[i] / 2;
                int idx = smallerNumberIndexByBS(nums,minNeed);
                if(nums[idx] <= minNeed){
                    for(int j = idx ; j >= 0; j--){
                        if(!marked[j]){
                            marked[i] = true;
                            marked[j] = true;
                            break;
                        }
                    }
                }
            }
        }
        int cnt = 0;
        for(boolean x : marked){
            if(x){
                cnt++;
            }
        }
        return  cnt;
    }

    /**
     * 二分查找<= x的最大值下标，。
     *T, F,左边界
     * @Return 返回的index有越界检查，不会越界
     */
    private int smallerNumberIndexByBS(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int pos = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else { //此时 <= key
                pos = mid;
                low = mid + 1;
            }
        }
        if (pos == -1) { //有可能比数组中所有数字都小
            return 0;
        }
        return pos;
    }
}

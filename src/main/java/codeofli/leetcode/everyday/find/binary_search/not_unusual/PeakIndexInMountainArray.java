package codeofli.leetcode.everyday.find.binary_search.not_unusual;

import java.util.stream.IntStream;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        //二分法,先选择左右两下标。
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            //左右都小于mid，说明mid是山峰。
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) break;
            //右边比左边高，说明山峰在右侧
            if (arr[mid + 1] > arr[mid]) left = mid;
                //右边比左边低，山峰在左侧
            else if (arr[mid + 1] < arr[mid]) right = mid;
        }
        return mid;
    }
}

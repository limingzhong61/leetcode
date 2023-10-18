package com.lmz.algorithm_practice.find.binary_search;

public class Search704 {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

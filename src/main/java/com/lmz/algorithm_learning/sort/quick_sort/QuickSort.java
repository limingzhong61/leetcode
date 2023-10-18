package com.lmz.algorithm_learning.sort.quick_sort;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-07-13 15:23
 */
public class QuickSort {
    int[] sort(int nums[], int left, int right) {
        if (left >= right) return nums;
        int idx = partition(nums, left, right);
        sort(nums, left, idx - 1);
        sort(nums, idx + 1, right);
        return nums;
    }

    private int partition(int[] nums, int left, int right) {
        int pIdx = left;
        while (left < right) {
            while (left < right && nums[pIdx] <= nums[right]) right--;
            while (left < right && nums[pIdx] >= nums[left]) left++;
            swap(nums, left, right);
        }
        swap(nums, pIdx, left);
        return left;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }

    public static void main(String[] args) {
        int[] test = {3, 1, 5, 6, 2, 10, -1};
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.sort(test, 0, test.length - 1)));
    }
}

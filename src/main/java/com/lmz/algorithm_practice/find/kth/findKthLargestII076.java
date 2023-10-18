package com.lmz.algorithm_practice.find.kth;

import java.util.PriorityQueue;

/**
 * @author: limingzhong
 * @create: 2023-03-24 9:47
 */
public class findKthLargestII076 {
    /**
     * 堆：nlogk
     * 1 <= k <= nums.length <= 104
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[k]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

    /**
     * 基于快速排序的选择方法
     */
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, nums.length - k, 0, nums.length - 1);
    }

    private int partition(int[] nums, int loc, int low, int high) {
        int pivot = nums[low];
        int preLow = low, preHigh = high;
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            swap(nums, low, high);
        }
        swap(nums, preLow, low);
        if (low == loc) {
            return nums[low];
        } else if (low > loc) {
            return partition(nums, loc, preLow, low - 1);
        } else {
            return partition(nums, loc, low + 1, preHigh);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

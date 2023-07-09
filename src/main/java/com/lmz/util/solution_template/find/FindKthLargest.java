package com.lmz.util.solution_template.find;

import com.lmz.my.leetcode.TransformUtil;
import com.lmz.algorithm.find.FindKthLargest215;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 */
public class FindKthLargest {
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

    /**
     * 最小堆， O(nlogk)
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        //1 <= k <= nums.length <= 105
        for (int i = 0; i < k; i++) {
            heap.add(nums[k]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        FindKthLargest215 findKthLargest215 = new FindKthLargest215();
        System.out.println(findKthLargest215.findKthLargest(TransformUtil.toIntArray("[3,2,3,1,2,4,5,5,6]"), 4));
        System.out.println(findKthLargest215.findKthLargest(TransformUtil.toIntArray("[3,2,3,1,2,4,5,5,6]"), 4) == 4);
    }
}

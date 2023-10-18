package com.lmz.algorithm_practice.other.old.sort;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class GetLeastNumbers40 {
    /**
     * my3:利用堆
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        //0 <= k <= arr.length <= 10000
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        if (k == arr.length) {
            return arr;
        }
        //构建最大堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            //@Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (int i = 0; i < k; i++) {
            heap.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (heap.peek() > arr[i]) {
                heap.poll();
                heap.add(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    /**
     * my2:quickSort：每次划分都会确定一个元素在待排数组中的最终位置
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        //0 <= k <= arr.length <= 10000
        if (k == arr.length) {
            return arr;
        }
        int index = partition(0, arr.length - 1, arr);
        int left = 0, right = arr.length - 1;
        while (index != k) {
            if (index < k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
            index = partition(left, right, arr);
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

    private int partition(int left, int right, int[] nums) {
        int pivot = left;
        while (left < right) {
            while (left < right && nums[right] >= nums[pivot]) right--;
            while (left < right && nums[left] <= nums[pivot]) left++;
            swap(left, right, nums);
        }
        swap(pivot, left, nums);
        return left;
    }

    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * my1:java内置函数
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void main(String[] args) {
        GetLeastNumbers40 getLeastNumbers40 = new GetLeastNumbers40();
        System.out.println(Arrays.toString(getLeastNumbers40.getLeastNumbers(
                TransformUtil.toIntArray("[3,2,1]"), 2)));
        System.out.println(Arrays.equals(getLeastNumbers40.getLeastNumbers(
                TransformUtil.toIntArray("[3,2,1]"), 2), TransformUtil.toIntArray("[2,1]")));

        System.out.println(Arrays.toString(getLeastNumbers40.getLeastNumbers(
                TransformUtil.toIntArray("[0,1,2,1]"), 1)));
        System.out.println(Arrays.equals(getLeastNumbers40.getLeastNumbers(
                TransformUtil.toIntArray("[0,1,2,1]"), 1), TransformUtil.toIntArray("[0]")));

        System.out.println(Arrays.toString(getLeastNumbers40.getLeastNumbers(
                TransformUtil.toIntArray("[0,0,2,3,2,1,1,2,0,4]"), 10)));

        System.out.println(Arrays.toString(getLeastNumbers40.getLeastNumbers(
                TransformUtil.toIntArray("[0,0,0,2,0,5]"), 0)));
        System.out.println(Arrays.equals(getLeastNumbers40.getLeastNumbers(
                TransformUtil.toIntArray("[0,0,0,2,0,5]"), 0), TransformUtil.toIntArray("[]")));



    }
}

package com.lmz.algorithm.other.old.sort;

import java.util.*;

public class MedianFinder41 {
    /**
     * leetcode
     */
    class MedianFinder1 {
        TreeMap<Integer, Integer> nums;
        int n;
        int[] left;
        int[] right;

        public MedianFinder1() {
            nums = new TreeMap<Integer, Integer>();
            n = 0;
            left = new int[2];
            right = new int[2];
        }

        public void addNum(int num) {
            nums.put(num, nums.getOrDefault(num, 0) + 1);
            if (n == 0) {
                left[0] = right[0] = num;
                left[1] = right[1] = 1;
            } else if ((n & 1) != 0) {
                if (num < left[0]) {
                    decrease(left);
                } else {
                    increase(right);
                }
            } else {
                if (num > left[0] && num < right[0]) {
                    increase(left);
                    decrease(right);
                } else if (num >= right[0]) {
                    increase(left);
                } else {
                    decrease(right);
                    System.arraycopy(right, 0, left, 0, 2);
                }
            }
            n++;
        }

        public double findMedian() {
            return (left[0] + right[0]) / 2.0;
        }

        private void increase(int[] iterator) {
            iterator[1]++;
            if (iterator[1] > nums.get(iterator[0])) {
                iterator[0] = nums.ceilingKey(iterator[0] + 1);
                iterator[1] = 1;
            }
        }

        private void decrease(int[] iterator) {
            iterator[1]--;
            if (iterator[1] == 0) {
                iterator[0] = nums.floorKey(iterator[0] - 1);
                iterator[1] = nums.get(iterator[0]);
            }
        }
    }

    /**
     * leetcode: 维护双堆：一个大顶堆，一个小顶堆
     * 大顶堆（最大值）<（最小值）小顶堆
     * N = m + n
     *关键在于：添加元素：
     * 向大顶堆添加元素：先向小顶堆添加，然后获取小顶堆顶，
     * 【小顶堆顶的最小值】所有大于【大顶堆的堆顶的最大值】元素的最小值。
     * 小顶堆同理
     */
    class MedianFinder {
        //维护双堆
        // 大根堆（小的，左半边）和 小根堆 （大的，右半边），左边size >= 右边size
        Queue<Integer> leftMaxHeap = new PriorityQueue<>((a, b) -> b - a);; // 大顶堆，保存较小的一半
        Queue<Integer> rightMinHeap = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        public MedianFinder() {
        }

        public void addNum(int num) {
            if(leftMaxHeap.size() == rightMinHeap.size()){
                rightMinHeap.add(num);
                leftMaxHeap.add(rightMinHeap.poll()); //添加右边最小的。
            }else{ // leftSize > rightSize
                leftMaxHeap.add(num);
                rightMinHeap.add(leftMaxHeap.poll()); //添加左边最大的。
            }
            // System.out.printf("%d,%d\n",leftMaxHeap.peek(), rightMinHeap.peek());
        }

        public double findMedian() {
            if(leftMaxHeap.size() > rightMinHeap.size()){
                return leftMaxHeap.peek();
            }else{
                return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
            }
        }
    }
}

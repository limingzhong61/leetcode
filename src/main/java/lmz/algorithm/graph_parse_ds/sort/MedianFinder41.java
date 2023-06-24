package lmz.algorithm.graph_parse_ds.sort;

import java.util.*;

public class MedianFinder41 {
    /**
     * leetcode
     */
    class MedianFinder {
        TreeMap<Integer, Integer> nums;
        int n;
        int[] left;
        int[] right;

        public MedianFinder() {
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
    class MedianFinder2 {
        Queue<Integer> minHeap = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);; // 大顶堆，保存较小的一半

        public MedianFinder2() { }

        public void addNum(int num) {
            //先大顶堆添加
            if(maxHeap.size() <= minHeap.size()){
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }else{
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        }

        public double findMedian() {
            if(maxHeap.size() == 0){
                return 0;
            }
            if(maxHeap.size() > minHeap.size()){
                return maxHeap.peek();
            }else{
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
        }
    }
}

package com.lmz.algorithm_practice.find.kth;

import java.util.PriorityQueue;

/**
 * @author: limingzhong
 * @create: 2023-03-20 10:53
 */
public class KthLargestII059 {
    class KthLargest {
        // 默认小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            for(int x : nums){
                addVal(k, x);
            }
        }

        private void addVal(int k, int x) {
            if(pq.size() < k){
                pq.add(x);
            }else{
                if(pq.peek() < x){
                    pq.poll();
                    pq.add(x);
                }
            }
        }

        public int add(int val) {
            addVal(k,val);
            return pq.peek();
        }
    }
}
